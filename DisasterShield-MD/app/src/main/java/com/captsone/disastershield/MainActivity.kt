package com.captsone.disastershield

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.captsone.disastershield.databinding.MainActivityBinding
import com.captsone.disastershield.view.home.MapsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startButton.setOnClickListener {
            Intent(this, MapsActivity::class.java).let{
                startActivity(it)
                finish()
            }
        }
    }
}