package ru.ahmedov.marketplace05ru.ui.screens.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ahmedov.marketplace05ru.R
import ru.ahmedov.marketplace05ru.data.global.Example
import ru.ahmedov.marketplace05ru.ui.screens.home.ui.HomeFragment
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    @IdRes
    var itemId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
        }

     //   sslIgnore()
        val  example = Example()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home ,
                R.id.navigation_catalog,
                R.id.navigation_basket
            )
        )
        navView.setupWithNavController(navController)
        bottomNavigationView = navView
        itemId = R.id.navigation_basket


        showBadge(7)

    }

    fun showBadge(
        value: Int
    ) {
        if (value == 0)
            removeBadge(bottomNavigationView, itemId)
        else {

            removeBadge(bottomNavigationView, itemId)
            val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
            val badge: View = LayoutInflater.from(applicationContext)
                .inflate(R.layout.basket_badge, bottomNavigationView, false)
            val text: TextView = badge.findViewById(R.id.basket_badge_text)
            if (value > 99) {
                text.text = "99"
            } else {
                text.text = value.toString()
            }
            itemView.addView(badge)
        }
    }

    private fun removeBadge(
        bottomNavigationView: BottomNavigationView,
        @IdRes itemId: Int
    ) {
        val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
        if (itemView.childCount == 3) {
            itemView.removeViewAt(2)
        }
    }

}