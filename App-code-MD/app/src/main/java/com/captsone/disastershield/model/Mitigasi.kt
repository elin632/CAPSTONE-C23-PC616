package com.captsone.disastershield.model

import com.google.gson.annotations.SerializedName

data class Mitigasi(
    val jenis: String,
    val gambar: Int,
    val judul: String,
    val sebelum: List<String>,
    val saat: List<String>,
    val setelah: List<String>
)

data class Coordinate(
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
)

data class ResponseWeather(
    @SerializedName("coord")
    val coordinate: Coordinate
)

data class Contact(
    val name: String,
    val phoneNumber: String,
)