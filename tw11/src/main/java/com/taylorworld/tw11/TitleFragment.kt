package com.taylorworld.tw11

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_title.*
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.fragment_misc.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TitleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TitleFragment : androidx.fragment.app.Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            //throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        //abstract val fragmentTransaction: Any

        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TitleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    public fun saveStr(view: View) {
        val strength = Integer.parseInt(editText2.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt(getString(R.string.STR), strength)
            apply()
        }
    }

    public fun saveDex(view: View) {
        val dexterity = Integer.parseInt(editText.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt(getString(R.string.DEX), dexterity)
            apply()
        }
    }

    public fun saveInt(view: View) {
        val intelligance = Integer.parseInt(editText4.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt(getString(R.string.INT), intelligance)
            apply()
        }
    }

    public fun saveWis(view: View) {
        val wisdom = Integer.parseInt(editText3.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt(getString(R.string.WIS), wisdom)
            apply()
        }
    }

    public fun saveCha(view: View) {
        val charisma = Integer.parseInt(editText5.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt(getString(R.string.CHA), charisma)
            apply()
        }
    }

    public fun saveCon(view: View) {
        val constitution = Integer.parseInt(editText6.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt(getString(R.string.CON), constitution)
            apply()
        }
    }

    public fun saveChr(view: View) {
        val chrname = editText7.text.toString()
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putString(getString(R.string.CHR), chrname)
            apply()
        }
    }
    override fun onResume() {
        super.onResume()

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

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
    }
}
