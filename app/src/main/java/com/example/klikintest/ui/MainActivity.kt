package com.example.klikintest.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.klikintest.R
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions


private const val REQUEST_LOCATION_PERMISSION = 1

class MainActivity : AppCompatActivity(), LocationListener {
    private lateinit var sharedPref: SharedPreferences
    private var locationManager: LocationManager?=null
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val perms = Manifest.permission.ACCESS_FINE_LOCATION
        if (!EasyPermissions.hasPermissions(this, perms)) {
            requestLocationPermission()
        }
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(REQUEST_LOCATION_PERMISSION)
    fun requestLocationPermission() {
        val perms = Manifest.permission.ACCESS_FINE_LOCATION
        if (EasyPermissions.hasPermissions(this, perms)) {
            locationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 200, 100F, this)
        } else {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.text_location_permission),
                REQUEST_LOCATION_PERMISSION,
                perms
            )
        }
    }


    override fun onLocationChanged(location: Location) {
        sharedPref = this.getSharedPreferences("location", MODE_PRIVATE)
        val latString = sharedPref.getString(this.getString(R.string.lat),"")
        val lonString = sharedPref.getString(this.getString(R.string.lon),"")
        if(latString.equals(location.latitude.toString()) && lonString.equals(location.longitude.toString()))
            return
        with (sharedPref.edit()) {
        putString(getString(R.string.lat), location.latitude.toString())
        putString(getString(R.string.lon), location.longitude.toString())
        apply()
    }
    }

    override fun onProviderEnabled(provider: String) {}

    override fun onProviderDisabled(provider: String) {}

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
}