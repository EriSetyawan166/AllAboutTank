package com.example.allabouttanks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.allabouttanks.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back)
        val tank = intent.getParcelableExtra<Tank>("key_tank")
        binding.tvTankName.text = tank?.name
        binding.tvDescription.text = tank?.description

        Glide.with(this)
            .load(tank?.photo)
            .into(binding.imgTank)

        binding.tvMainArmament.text = getString(R.string.nilai_spesifikasi, tank?.main_armament)
        binding.tvSecondaryArmament.text =
            getString(R.string.nilai_spesifikasi, tank?.secondary_armament)
        binding.tvWeight.text = getString(R.string.nilai_spesifikasi, tank?.weight)
        binding.tvTopSpeed.text = getString(R.string.nilai_spesifikasi, tank?.maximum_speed)
        binding.tvArmour.text = getString(R.string.nilai_spesifikasi, tank?.armour)
        binding.tvHistory.text = tank?.history
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }

            R.id.action_share -> {
                val tank = intent.getParcelableExtra<Tank>("key_tank")
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, tank?.link)
                startActivity(Intent.createChooser(shareIntent, "Share menggunakan"))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

}