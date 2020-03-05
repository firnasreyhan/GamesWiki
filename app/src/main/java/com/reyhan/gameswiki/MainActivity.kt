package com.reyhan.gameswiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        floatingActionButton.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            startActivity(shareIntent)
        }

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0)

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id : Int = item.itemId

        if (id == R.id.nav_action) {
            startActivity(Intent(this, ActionActivity::class.java))
        } else if (id == R.id.nav_rpg) {
            startActivity(Intent(this, RpgActivity::class.java))
        } else if (id == R.id.nav_shooting) {
            startActivity(Intent(this, ShootingActivity::class.java))
        } else if (id == R.id.nav_racing) {
            startActivity(Intent(this, RacingActivity::class.java))
        } else if (id == R.id.nav_survival) {
            startActivity(Intent(this, SurvivalActivity::class.java))
        } else if (id == R.id.nav_puzzle) {
            startActivity(Intent(this, PuzzleActivity::class.java))
        } else if (id == R.id.nav_share) {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            startActivity(shareIntent)
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}