package com.powerteamdeveloper.tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val firstFragment =FirstFragment()
        val secondFragment =SecondFragment()
        val thirdFragment =ThirdFragment()

        setCurrentFragment(firstFragment)
//        bottomNavigationView.OnNavigationItemSelectedListener  {item ->
//            when(item.itemId){
//                R.id.miHome -> {
//                    setCurrentFragment(firstFragment)
//                true
//                }
//                R.id.miMessages -> {
//                    setCurrentFragment(secondFragment)
//                true
//                }
//                R.id.miProfile ->{
//                    setCurrentFragment(thirdFragment)
//                    true
//                }
//                else ->false
//
//                }
//            }

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(firstFragment)
                R.id.miMessages -> setCurrentFragment(secondFragment)
                R.id.miProfile -> setCurrentFragment(thirdFragment)
            }
            true
        }

        bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply {
            number = 10
            isVisible = true
        }
    }


    private  fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragmentBottom,fragment)
        }
}