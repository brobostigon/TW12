package com.taylorworld.twwear1

//import android.app.Activity
import android.content.Context
import android.os.Bundle
//import android.support.wear.widget.drawer.WearableActionDrawerView
//import android.support.wear.widget.drawer.WearableDrawerLayout
//import android.support.wear.widget.drawer.WearableNavigationDrawerView
import android.support.wearable.activity.WearableActivity
//import android.view.MenuItem
//import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()
    }

    override fun onStop() {
        super.onStop()

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);

        var strength = Integer.parseInt(editText3.text.toString())
        // this should be getPreferences
        with(sharedPref.edit()) {
            putInt(getString(R.string.STR), strength)
            apply()
        }

        var dexterity = Integer.parseInt(editText4.text.toString())
        // this should be getPreferences
        //val sharedPref = this?.getPreferences(Context.MODE_PRIVATE);
        with(sharedPref.edit()) {
            putInt(getString(R.string.DEX), dexterity)
            apply()
        }

        var intelligence = Integer.parseInt(editText5.text.toString())
        with(sharedPref.edit()) {
            putInt(getString(R.string.INT), intelligence)
            apply()
        }
        var constitution = Integer.parseInt(editText6.text.toString())
        with(sharedPref.edit()) {
            putInt(getString(R.string.CON), constitution)
            apply()
        }

        var wisdom = Integer.parseInt(editText7.text.toString())
        with(sharedPref.edit()) {
            putInt(getString(R.string.WIS), wisdom)
            apply()
        }

        var charisma = Integer.parseInt(editText8.text.toString())
        with(sharedPref.edit()) {
            putInt(getString(R.string.CHA), charisma)
            apply()
        }

    }

    override fun onStart() {
        super.onStart()
        //public fun readSP(view: View) {

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE)

        val mystr = sharedPref.getInt(getString(R.string.STR), 0);
        editText3.setText(Integer.toString(mystr))

        val mydex = sharedPref.getInt(getString(R.string.DEX), 0);
        editText4.setText(Integer.toString(mydex))

        val myint = sharedPref.getInt(getString(R.string.INT), 0);
        editText5.setText(Integer.toString(myint))

        val mywis = sharedPref.getInt(getString(R.string.WIS), 0);
        editText7.setText(Integer.toString(mywis))

        val mycon = sharedPref.getInt(getString(R.string.CON), 0);
        editText6.setText(Integer.toString(mycon))

        val mycha = sharedPref.getInt(getString(R.string.CHA), 0);
        editText8.setText(Integer.toString(mycha))
    }
}

