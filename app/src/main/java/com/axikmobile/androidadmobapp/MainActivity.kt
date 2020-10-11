package com.axikmobile.androidadmobapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private var content: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content = findViewById(R.id.fragment_container) as FrameLayout
        val navigation = findViewById(R.id.bottom_nativation_view) as BottomNavigationView
        navigation.setOnNavigationItemReselectedListener { myOnNavigationItemSelectedListener }
    }

    private val myOnNavigationItemSelectedListener = object: BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {

                R.id.action_banner -> {
                   // val fragment = BannerFragment()
                 //   loadFragment(fragment)
                    return true
                }

                R.id.action_intersticial -> {
                   // val fragment = IntersticialFragment()
                   //loadFragment(fragment)
                    return true

                }

                R.id.action_video -> {
                   // val fragment = VideoFragment()
                   // loadFragment(fragment)
                    return true

                }
            }
              return false
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_out,R.anim.design_bottom_sheet_slide_in)
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }


}