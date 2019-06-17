package com.taylorworld.app2

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_stats.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    public fun saveStr(view: View) {
        var strength = Integer.parseInt(editText2.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.STR), strength)
            apply()
        }
        Toast.makeText(this, "Strength Saved", Toast.LENGTH_SHORT).show();
    }

    public fun saveDex(view: View) {
        var dexterity = Integer.parseInt(editText.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.DEX), dexterity)
            apply()
        }
        Toast.makeText(this, "Dexterity Saved", Toast.LENGTH_SHORT).show();
    }

    public fun saveInt(view: View) {
        var intelligance = Integer.parseInt(editText4.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.INT), intelligance)
            apply()
        }
        Toast.makeText(this, "Intelligence Saved", Toast.LENGTH_SHORT).show();
    }

    public fun saveWis(view: View) {
        var wisdom = Integer.parseInt(editText3.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.WIS), wisdom)
            apply()
        }
        Toast.makeText(this, "Wisdom Saved", Toast.LENGTH_SHORT).show();
    }

    public fun saveCha(view: View) {
        var charisma = Integer.parseInt(editText5.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.CHA), charisma)
            apply()
        }
        Toast.makeText(this, "charisma Saved", Toast.LENGTH_SHORT).show();
    }

    public fun saveCon(view: View) {
        var constitution = Integer.parseInt(editText6.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.CON), constitution)
            apply()
        }
        Toast.makeText(this, "Constitution Saved", Toast.LENGTH_SHORT).show();
    }

    public fun saveChr(view: View) {
        var chrname = editText7.text.toString()
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putString(getString(R.string.CHR), chrname)
            apply()
        }
        Toast.makeText(this, "Character Name Saved", Toast.LENGTH_SHORT).show();
    }

    override fun onResume() {
        super.onResume()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)

        //GlobalScope.launch {

            val mystr = sharedPref.getInt(getString(R.string.STR), 0);
            editText2.setText(Integer.toString(mystr))

            val mydex = sharedPref.getInt(getString(R.string.DEX), 0);
            editText.setText(Integer.toString(mydex))

            val myint = sharedPref.getInt(getString(R.string.INT), 0);
            editText4.setText(Integer.toString(myint))

            val mywis = sharedPref.getInt(getString(R.string.WIS), 0);
            editText3.setText(Integer.toString(mywis))

            val mycon = sharedPref.getInt(getString(R.string.CON), 0);
            editText6.setText(Integer.toString(mycon))

            val mycha = sharedPref.getInt(getString(R.string.CHA), 0);
            editText5.setText(Integer.toString(mycha))

            val mychr = sharedPref.getString(getString(R.string.CHR), null);
            editText7.setText(mychr)

        Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
    }
}

//}
