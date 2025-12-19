package com.example.portfolio

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.portfolio.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        // 🌗 Apply saved theme BEFORE UI loads
        val prefs = getSharedPreferences("theme_prefs", MODE_PRIVATE)
        val isDarkMode = prefs.getBoolean("dark_mode", false)

        AppCompatDelegate.setDefaultNightMode(
            if (isDarkMode)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
        )

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Force BLACK status bar always
        window.statusBarColor = Color.BLACK

        // Make status bar icons WHITE (important for black background)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = 0
        }


        // 🌗 Theme Toggle Button (Top Right)
        val themeBtn: ImageButton = findViewById(R.id.btnThemeToggle)
        val editor = prefs.edit()

        // Set correct icon on launch
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            themeBtn.setImageResource(R.drawable.ic_light_mode)
        } else {
            themeBtn.setImageResource(R.drawable.ic_dark_mode)
        }

        themeBtn.setOnClickListener {
            val isDark =
                AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

            if (isDark) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                themeBtn.setImageResource(R.drawable.ic_dark_mode)
                editor.putBoolean("dark_mode", false)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                themeBtn.setImageResource(R.drawable.ic_light_mode)
                editor.putBoolean("dark_mode", true)
            }
            editor.apply()
        }

        // ViewPager Adapter
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter
        binding.viewPager.offscreenPageLimit = 1

        // Tabs Setup
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "About"
                1 -> tab.text = "Projects"
                2 -> tab.text = "Resume"
                3 -> tab.text = "Certificates"
                4 -> tab.text = "Experiences"
            }
        }.attach()

        // LinkedIn click
        binding.linkedinIcon.setOnClickListener {
            openLink("https://www.linkedin.com/in/mrudula-sadafule-30b942299/")
        }

        // GitHub click
        binding.githubIcon.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
