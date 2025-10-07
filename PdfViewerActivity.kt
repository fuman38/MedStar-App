package com.medstar.medstarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import android.widget.LinearLayout

class PdfViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pdfView = PDFView(this, null)
        pdfView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        setContentView(pdfView)

        val fileName = intent.getStringExtra("pdfFile")
        fileName?.let {
            pdfView.fromAsset(it).load()
        }
    }
}
