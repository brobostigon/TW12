package com.taylorworld.tw11

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_misc.*
import kotlinx.android.synthetic.main.fragment_title.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener ,
    TitleFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //val fab: FloatingActionButton = findViewById(R.id.fab)
        //fab.setOnClickListener { view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show()
        //}
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = TitleFragment()
        val fragment2 = MiscFragment()
        fragmentTransaction.add(R.id.contentlayout, fragment)
        fragmentTransaction.remove(fragment2)
        //fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
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
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/brobostigon/"))
                startActivity(i)
            }
            R.id.nav_gallery -> {
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                val fragment = TitleFragment()
                //val fragment2 = MiscFragment()
                fragmentTransaction.replace(R.id.contentlayout, fragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            R.id.nav_slideshow -> {
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                //val fragment = TitleFragment()
                val fragment2 = MiscFragment()
                fragmentTransaction.replace(R.id.contentlayout, fragment2)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
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
    public fun saveAC(view: View) {
        var armorclass = Integer.parseInt(editText8.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("AC", armorclass)
            apply()
        }
        Toast.makeText(this, "AC Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveHP(view: View) {
        var hitpoints = Integer.parseInt(editText10.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("HP", hitpoints)
            apply()
        }
        Toast.makeText(this, "HP Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveINIT(view: View) {
        var initiative = Integer.parseInt(editText11.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("initiative", initiative)
            apply()
        }
        Toast.makeText(this, "Initiative Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveFortitude(view: View) {
        var fortitude = Integer.parseInt(editText12.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("fortitude", fortitude)
            apply()
        }
        Toast.makeText(this, "Fortitude Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveReflex(view: View) {
        var reflex = Integer.parseInt(editText13.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("reflex", reflex)
            apply()
        }
        Toast.makeText(this, "Reflex Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveWill(view: View) {
        var will = Integer.parseInt(editText14.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("will", will)
            apply()
        }
        Toast.makeText(this, "Will Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveSpeed(view: View) {
        var speed = Integer.parseInt(editText15.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("speed", speed)
            apply()
        }
        Toast.makeText(this, "Speed Saved", Toast.LENGTH_SHORT).show();
    }
    public fun saveGoldPieces(view: View) {
        var goldpieces = Integer.parseInt(editText9.text.toString())
        // this should be getPreferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt("goldpieces", goldpieces)
            apply()
        }
        Toast.makeText(this, "Cash Saved", Toast.LENGTH_SHORT).show();
    }

    override fun onResume() {
        super.onResume()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)

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

        val armorclass = sharedPref.getInt("AC", 0);
        editText8.setText(Integer.toString(armorclass))

        val hitpoints = sharedPref.getInt("HP", 0);
        editText10.setText(Integer.toString(hitpoints))

        val init = sharedPref.getInt("initiative", 0);
        editText11.setText(Integer.toString(init))

        val fortitude = sharedPref.getInt("fortitude", 0);
        editText12.setText(Integer.toString(fortitude))

        val reflex = sharedPref.getInt("reflex", 0);
        editText13.setText(Integer.toString(reflex))

        val will = sharedPref.getInt("will", 0);
        editText14.setText(Integer.toString(will))

        val speed = sharedPref.getInt("speed", 0);
        editText15.setText(Integer.toString(speed))

        val goldpieces = sharedPref.getInt("goldpieces", 0);
        editText9.setText(Integer.toString(goldpieces))

        Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
    }
}