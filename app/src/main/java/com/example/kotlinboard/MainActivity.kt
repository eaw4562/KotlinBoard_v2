package com.example.kotlinboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.kotlinboard.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binidng : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binidng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binidng.root)

        binidng.navigation.selectedItemId = R.id.home

        binidng.navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)

    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        item: MenuItem ->  when(item.itemId){
        R.id.list -> {
            item.setIcon(R.drawable.baseline_work_24)
            binidng.navigation.menu.findItem(R.id.home).setIcon(R.drawable.unselected_home_icon_24)
            binidng.navigation.menu.findItem(R.id.user).setIcon(R.drawable.baseline_timer_off_24)
            true
        }
        R.id.home -> {
            item.setIcon(R.drawable.baseline_timer_24)
            binidng.navigation.menu.findItem(R.id.list).setIcon(R.drawable.unselected_home_icon_24)
            binidng.navigation.menu.findItem(R.id.user).setIcon(R.drawable.unselected_list_icon_24)
            true
        }
        R.id.user -> {
            item.setIcon(R.drawable.baseline_home_24)
            binidng.navigation.menu.findItem(R.id.list).setIcon(R.drawable.unselected_list_icon_24)
            binidng.navigation.menu.findItem(R.id.home).setIcon(R.drawable.baseline_timer_off_24)
            true
        }
        else -> false
            }
        }
    }