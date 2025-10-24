package com.example.portfolio

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.portfolio.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set status bar color to match gray background
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#6c757d")
        }

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        binding.viewPager.offscreenPageLimit = 1

       // binding.viewPager.setPageTransformer(FadePageTransformer())

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "About"
                1 -> tab.text = "Projects"
                2 -> tab.text = "Resume"
                3 -> tab.text = "Certificates"
                4 -> tab.text = "Experiences"
            }
        }.attach()

        // Open LinkedIn
        binding.linkedinIcon.setOnClickListener {
            openLink("https://www.linkedin.com/in/mrudula-sadafule-30b942299/")
        }

        // Open GitHub
        binding.githubIcon.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
