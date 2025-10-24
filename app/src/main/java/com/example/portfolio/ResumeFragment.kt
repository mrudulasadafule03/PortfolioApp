package com.example.portfolio

import android.app.DownloadManager
import android.content.*
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import java.io.File

class ResumeFragment : Fragment() {

    private val resumeUrl = "https://drive.google.com/uc?export=download&id=1r54xGzWuI2cQKGY7g1t7ZG86gOnK4CYt"
    private var downloadId: Long = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resume, container, false)

        val viewBtn: MaterialButton = view.findViewById(R.id.viewResume)
        val downloadBtn: MaterialButton = view.findViewById(R.id.downloadResume)

        // View Resume (online)
        viewBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resumeUrl))
            startActivity(intent)
        }

        // Download Resume
        downloadBtn.setOnClickListener {
            val request = DownloadManager.Request(Uri.parse(resumeUrl))
                .setTitle("MrudulaResume.pdf")
                .setDescription("Downloading Resume…")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "MrudulaResume.pdf")

            val downloadManager = requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            downloadId = downloadManager.enqueue(request)

            Toast.makeText(requireContext(), "Downloading Resume…", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    // Listen for when download completes
    private val onDownloadComplete = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (id == downloadId) {
                val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Resume.pdf")
                if (file.exists()) {
                    val uri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.provider", file)
                    val openIntent = Intent(Intent.ACTION_VIEW)
                    openIntent.setDataAndType(uri, "application/pdf")
                    openIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    startActivity(openIntent)
                } else {
                    Toast.makeText(requireContext(), "File not found!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        requireContext().registerReceiver(onDownloadComplete, filter, Context.RECEIVER_NOT_EXPORTED)
    }


    override fun onPause() {
        super.onPause()
        requireContext().unregisterReceiver(onDownloadComplete)
    }
}
