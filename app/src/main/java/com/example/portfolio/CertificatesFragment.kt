package com.example.portfolio

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment

class CertificatesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_certificates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Android Certificates
        val androidCert1 = view.findViewById<ImageView>(R.id.android_cert1)
        androidCert1.setOnClickListener { showFullScreenImage(R.drawable.android_cert1) }

        // Python Certificates
        val pythonCert1 = view.findViewById<ImageView>(R.id.python_cert1)
        val pythonCert2 = view.findViewById<ImageView>(R.id.python_cert2)
        val pythonCert3 = view.findViewById<ImageView>(R.id.python_cert3)
        val pythonCert4 = view.findViewById<ImageView>(R.id.python_cert4)

        pythonCert1.setOnClickListener { showFullScreenImage(R.drawable.python_cert1) }
        pythonCert2.setOnClickListener { showFullScreenImage(R.drawable.python_cert2) }
        pythonCert3.setOnClickListener { showFullScreenImage(R.drawable.python_cert3) }
        pythonCert4.setOnClickListener { showFullScreenImage(R.drawable.python_cert4) }

        // Microsoft Certificates
        val msCert1 = view.findViewById<ImageView>(R.id.microsoft_cert1)
        val msCert2 = view.findViewById<ImageView>(R.id.microsoft_cert2)

        msCert1.setOnClickListener { showFullScreenImage(R.drawable.microsoft_cert1) }
        msCert2.setOnClickListener { showFullScreenImage(R.drawable.microsoft_cert2) }

        // Skill Enhancement Certificates
        val skillCert1 = view.findViewById<ImageView>(R.id.skill_cert1)
        val skillCert2 = view.findViewById<ImageView>(R.id.skill_cert2)

        skillCert1.setOnClickListener { showFullScreenImage(R.drawable.skill_cert1) }
        skillCert2.setOnClickListener { showFullScreenImage(R.drawable.skill_cert2) }
    }

    // Function to show full-screen popup
    private fun showFullScreenImage(imageResId: Int) {
        val dialog = Dialog(requireContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.dialog_fullscreen_image)

        val imageView = dialog.findViewById<ImageView>(R.id.fullscreen_image)
        val closeBtn = dialog.findViewById<ImageButton>(R.id.btn_close)

        imageView.setImageResource(imageResId)

        // Close dialog when close button is clicked
        closeBtn.setOnClickListener {
            dialog.dismiss()
        }

        // Optional: also allow dismiss on tapping image
        imageView.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

}
