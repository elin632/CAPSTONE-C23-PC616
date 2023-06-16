package com.captsone.disastershield.view.mitigasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.captsone.disastershield.R
import com.captsone.disastershield.databinding.ActivityMitigasiBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MitigasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMitigasiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMitigasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.banjirButton.setOnClickListener {
            val intent = Intent(this, DetailMitigasiActivity::class.java)
            intent.putExtra("namaBencana", "banjir")
            startActivity(intent)
        }
        binding.gempaButton.setOnClickListener {
            val intent = Intent(this, DetailMitigasiActivity::class.java)
            intent.putExtra("namaBencana", "gempa")
            startActivity(intent)
        }
    }
}