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
import kotlinx.android.synthetic.main.fragment_misc.*
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.fragment_title.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MiscFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MiscFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MiscFragment : androidx.fragment.app.Fragment() {
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
        return inflater.inflate(R.layout.fragment_misc, container, false)
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
         * @return A new instance of fragment MiscFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MiscFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    public fun saveAC(view: View) {
        val armorclass = Integer.parseInt(editText8.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("AC", armorclass)
            apply()
        }
    }
    public fun saveHP(view: View) {
        val hitpoints = Integer.parseInt(editText10.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("HP", hitpoints)
            apply()
        }
    }
    public fun saveINIT(view: View) {
        val initiative = Integer.parseInt(editText11.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("initiative", initiative)
            apply()
        }
    }
    public fun saveFortitude(view: View) {
        val fortitude = Integer.parseInt(editText12.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("fortitude", fortitude)
            apply()
        }
    }
    public fun saveReflex(view: View) {
        val reflex = Integer.parseInt(editText13.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("reflex", reflex)
            apply()
        }
    }
    public fun saveWill(view: View) {
        val will = Integer.parseInt(editText14.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("will", will)
            apply()
        }
    }
    public fun saveSpeed(view: View) {
        val speed = Integer.parseInt(editText15.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("speed", speed)
            apply()
        }
    }
    public fun saveGoldPieces(view: View) {
        val goldpieces = Integer.parseInt(editText9.text.toString())
        // this should be getPreferences
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        with(sharedPref.edit()) {
            putInt("goldpieces", goldpieces)
            apply()
        }
    }
    override fun onResume() {
        super.onResume()

        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

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
}
