package com.captsone.disastershield.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import com.captsone.disastershield.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.captsone.disastershield.databinding.ActivityMapsBinding
import com.captsone.disastershield.view.mitigasi.MitigasiActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var loadingBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.mitigasiButton.setOnClickListener{
            startActivity(Intent(this, MitigasiActivity::class.java))
        }
        loadingBar = binding.progressBar

        binding.searchBar.editText?.setOnEditorActionListener { textView, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE || i == EditorInfo.IME_NULL){
                viewModel.getMapData(textView.text.toString())
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        viewModel.isLoading.observe(this){
            showLoading(it)
        }
        viewModel.message.observe(this){
            showMessage(it)
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        viewModel.dataMap.observe(this){
            val locationNow = LatLng(it.lat, it.lon)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationNow))
            mMap.addMarker(MarkerOptions().position(locationNow).title(viewModel.cityName.value))
        }
    }
    private fun showLoading(p: Boolean){
        loadingBar.visibility = if (p) View.VISIBLE else View.INVISIBLE
    }
    private fun showMessage(p: String){
        Toast.makeText(this, p, Toast.LENGTH_LONG).show()
    }
}