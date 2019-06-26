package com.taylorworld.tw1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject.NULL

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //val mystr: Int = intent.getIntExtra("data", 0)
        //editText8.setText(Integer.toString(mystr))
    }

    public fun activity1(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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

        GlobalScope.launch {

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
        }
        Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}