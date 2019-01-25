package com.mksengun.vehicle.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mksengun.vehicle.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, VehicleListFragment()).commit()
    }
}
