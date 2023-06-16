package com.captsone.disastershield.view.mitigasi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.captsone.disastershield.adapter.RecyclerViewAdapter
import com.captsone.disastershield.databinding.ActivityDetailMitigasiBinding
import com.captsone.disastershield.util.Util.banjir
import com.captsone.disastershield.util.Util.gempa
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMitigasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMitigasiBinding
    private lateinit var listSebelum: RecyclerView
    private lateinit var listSaat: RecyclerView
    private lateinit var listSesudah: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMitigasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaBencana = intent.getStringExtra("namaBencana") ?: "gempa"
        binding.backButton.setOnClickListener {
            onBackPressed()
        }
        val list = if (namaBencana == "gempa") gempa else banjir
        binding.labelMitigasi.text = list.judul
        binding.shapeableImageView2.setImageResource(list.gambar)

        listSebelum = binding.listViewSebelum
        listSaat = binding.listViewSaat
        listSesudah = binding.listViewSesudah

        val sebelumLayoutManager = LinearLayoutManager(this)
        val saatLayoutManager = LinearLayoutManager(this)
        val sesudahLayoutManager = LinearLayoutManager(this)

        listSebelum.layoutManager = sebelumLayoutManager
        listSaat.layoutManager = saatLayoutManager
        listSesudah.layoutManager = sesudahLayoutManager

        val sebelumAdapter = RecyclerViewAdapter(list.sebelum)
        listSebelum.adapter = sebelumAdapter
        listSaat.adapter = RecyclerViewAdapter(list.saat)
        listSesudah.adapter = RecyclerViewAdapter(list.setelah)

        binding.sebelumDropButton.setOnClickListener {
            changeVisibility(listSebelum)
        }

        binding.SaatDropButton.setOnClickListener {
            changeVisibility(listSaat)
        }

        binding.SesudahDropButton.setOnClickListener {
            changeVisibility(listSesudah)
        }
    }

    private fun changeVisibility(listView: RecyclerView) {

        if (listView.visibility == View.GONE) {
            listView.visibility = View.VISIBLE
        } else {
            listView.visibility = View.GONE
        }
    }
}