package com.medstar.medstarapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.medstar.medstarapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMedicine.setOnClickListener {
            openPdf("medicine.pdf")
        }

        binding.btnPediatrics.setOnClickListener {
            openPdf("pediatrics.pdf")
        }

        binding.btnGynecology.setOnClickListener {
            openPdf("gynecology(2).pdf")
        }

        binding.btnMcq.setOnClickListener {
            startActivity(Intent(this, McqActivity::class.java))
        }
    }

    private fun openPdf(fileName: String) {
        val intent = Intent(this, PdfViewerActivity::class.java)
        intent.putExtra("pdfFile", fileName)
        startActivity(intent)
    }
}
