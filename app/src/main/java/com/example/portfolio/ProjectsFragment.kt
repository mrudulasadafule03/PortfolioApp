package com.example.portfolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ProjectsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Driver Drowsiness Detection System
        view.findViewById<View>(R.id.github_link_driver)?.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03/DriverDrowsinessSystem")
        }

        // Home Automation System using Raspberry Pi
        view.findViewById<View>(R.id.github_link_homeautomation)?.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03/HomeAutomation.git")
        }

        // Code Club Community App
        view.findViewById<View>(R.id.github_link_codeclub)?.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03/CodeClub_Android")
        }

        // Online Voting System
        view.findViewById<View>(R.id.github_link_voting)?.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03/OnlineVotingSystem")
        }

        // Photography World
        view.findViewById<View>(R.id.github_link_photography)?.setOnClickListener {
            openLink("https://github.com/mrudulasadafule03/PhotoGraphyworld")
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
