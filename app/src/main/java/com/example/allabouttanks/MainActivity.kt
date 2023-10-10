package com.example.allabouttanks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Tank>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Tank> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataMainArmament = resources.getStringArray(R.array.data_senjata_utama)
        val dataSecondaryArmament = resources.getStringArray(R.array.data_senjata_sekunder)
        val dataWeight = resources.getStringArray(R.array.data_berat)
        val dataMaximumSpeed = resources.getStringArray(R.array.data_kecepatan_maksimum)
        val dataArmour = resources.getStringArray(R.array.data_ketebalan_armor)
        val dataHistory = resources.getStringArray(R.array.data_sejarah)
        val dataLink = resources.getStringArray(R.array.data_link)

        val listTanks = ArrayList<Tank>()

        for (i in dataName.indices) {
            val tank = Tank(
                dataName[i],
                dataDescription[i],
                dataPhoto[i],
                dataMainArmament[i],
                dataSecondaryArmament[i],
                dataWeight[i],
                dataMaximumSpeed[i],
                dataArmour[i],
                dataHistory[i],
                dataLink[i]
            )
            listTanks.add(tank)
        }
        return listTanks
    }


    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listTankAdapter = ListTankAdapter(list)
        rvHeroes.adapter = listTankAdapter
    }
}