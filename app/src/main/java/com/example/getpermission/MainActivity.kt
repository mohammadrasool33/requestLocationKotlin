package com.example.getpermission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
//    companion object {
//        private const val PERMISSIONS_REQUEST_CODE = 100 // Defined request code as a constant
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button) // Correct naming conventions
        button.setOnClickListener {
            checkAndRequestPermissions()
        }
    }

    private fun getLocationPermissionStatus() =
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED

    private fun checkAndRequestPermissions() {
        val permissionsToRequest = mutableListOf<String>()
        if (!getLocationPermissionStatus()) {
            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
        }

    }
}
