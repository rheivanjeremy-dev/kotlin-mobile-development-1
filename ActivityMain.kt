package com.mobprog.inputapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// MainActivity adalah activity utama saat aplikasi dijalankan
class ActivityMain : AppCompatActivity() {

    // Fungsi onCreate dijalankan pertama kali saat activity dibuat
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan activity dengan file layout activity_main.xml
        setContentView(R.layout.activity_main)

        // Menghubungkan variabel Kotlin dengan komponen di XML
        val etInput1 = findViewById<EditText>(R.id.etInput1)
        val etInput2 = findViewById<EditText>(R.id.etInput2)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val etAngka1 = findViewById<EditText>(R.id.etAngka1)
        val etAngka2 = findViewById<EditText>(R.id.etAngka2)

        // Event listener saat tombol ditekan
        btnProses.setOnClickListener {

            // Mengambil teks dari EditText dan mengubahnya menjadi String
            val input1 = etInput1.text.toString()
            val input2 = etInput2.text.toString()
            val angka1Text = etAngka1.text.toString()
            val angka2Text = etAngka2.text.toString()

            // Validasi sederhana: memastikan input tidak kosong
            if (input1.isNotEmpty() &&
                input2.isNotEmpty() &&
                angka1Text.isNotEmpty() &&
                angka2Text.isNotEmpty()
            ) {

                // Mengubah String menjadi tipe data Int
                val angka1 = angka1Text.toInt()
                val angka2 = angka2Text.toInt()

                // Menggabungkan dua input menjadi satu teks
                val hasilGabung = "Input 1: $input1, Input 2: $input2"

                // Operasi aritmatika dasar
                val hasilTambah = angka1 + angka2      // penjumlahan
                val hasilKurang = angka1 - angka2      // pengurangan
                val hasilKali = angka1 * angka2         // perkalian
                val hasilBagi = if (angka2 != 0) {
                    angka1 / angka2                    // pembagian
                } else {
                    0                                  // mencegah pembagian dengan nol
                }

                // Menampilkan hasil ke TextView
                tvHasil.text =
                    "Hasil Gabung: $hasilGabung\n" +
                            "Hasil Tambah: $hasilTambah\n" +
                            "Hasil Kurang: $hasilKurang\n" +
                            "Hasil Kali: $hasilKali\n" +
                            "Hasil Bagi: $hasilBagi"

            } else {
                // Menampilkan pesan jika input belum lengkap
                tvHasil.text = "Harap isi semua input"
            }
        }
    }
}

