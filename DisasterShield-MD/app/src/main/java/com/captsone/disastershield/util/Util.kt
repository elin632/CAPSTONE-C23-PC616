package com.captsone.disastershield.util

import com.captsone.disastershield.R
import com.captsone.disastershield.model.Mitigasi

object Util {
    val banjir =
        Mitigasi(
            "Banjir",
            R.drawable.img_banjir,
            "Mitigasi Bencana Banjir",
            listOf("Mengetahui istilah-istilah peringatan yang berhubungan dengan bahaya banjir, seperti Siaga I sampai dengan Siaga IV dan langkah-langkah apa yang harus dilakukan",
            "mengetahui saluran dan jalur yang sering dilalui air banjir dan apa dampaknya untuk rumah kita", "hindari membangun di tempat rawan banjir kecuali ada upaya penguatan dan peninggian bangunan rumah"),
            listOf("Segeralah evakuasi ke tempat yang lebih tinggi", "Waspada terhadap arus bawah, saluran air, kubangan, dan tempat-tempat lain yang tergenang air",
            "Waspada saluran air atau tempat melintasnya air yang kemungkinan akan dilalui oleh arus yang deras karena kerap kali banjir bandang tiba tanpa peringatan"),
            listOf("Bersihkan tempat tinggal dan lingkungan rumah dari sisa-sisa kotoran setelah banjir", "Waspada dengan instalasi listrik",
            "Dengarkan berita atau informasi mengenai kondisi air, serta di mana mendapatkan bantuan perumahan/shelter, pakaian, dan makanan", "Kembali ke rumah sesuai dengan perintah dari pihak yang berwenang"),
        )
    val gempa =
        Mitigasi(
            "Gempa",
            R.drawable.img_gempa,
            "Mitigasi Bencana Gempa Bumi",
            listOf(
                "Pastikan bahwa struktur dan letak rumah Anda dapat terhindar dari bahaya gempabumi",
                "Catat nomor telepon penting yang dapat dihubungi pada saat terjadi gempabumi",
                "Perabotan (lemari, cabinet, dll) diatur menempel pada dinding (dipaku, diikat, dll) untuk menghindari jatuh, roboh, bergeser pada saat terjadi gempabumi",
                "Perhatikan letak pintu, lift serta tangga darurat yang ada",
                "Simpan bahan yang mudah terbakar pada tempat yang tidak mudah pecah agar terhindar dari kebakaran"
            ),
            listOf(
                "Jika Anda berada di dalam bangunan",
                "1. Lindungi badan dan kepala Anda dari reruntuhan bangunan dengan bersembunyi di bawah meja dll\n" +
                        "2. Cari tempat yang paling aman dari reruntuhan dan goncangan\n" +
                        "3. Lari ke luar apabila masih dapat dilakukan",
                "Jika berada di luar bangunan atau area terbuka",
                "1. Menghindari dari bangunan yang ada di sekitar Anda seperti gedung, tiang listrik, pohon, dll\n" +
                        "2. Perhatikan tempat Anda berpijak, hindari apabila terjadi rekahan tanah"
            ),
            listOf(
                "Keluar dari bangunan tersebut dengan tertib\n",
                "Jangan menggunakan tangga berjalan atau lift, gunakan tangga biasa",
                "Periksa apabila terjadi kebakaran/kebocoran gas",
                "Jangan mamasuki bangunan yang sudah terkena gempa karena kemungkinan masih terdapat reruntuhan."
            ),
        )
}