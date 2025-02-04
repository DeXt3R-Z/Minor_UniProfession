package com.example.minor_tbd.onboarding_screens.registration_screen

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.minor_tbd.home_screen.Fragment_MainScreen
import com.example.minor_tbd.MainActivity
import com.example.minor_tbd.R
import soup.neumorphism.NeumorphButton


class Fragment_RegistrationComplete_Welcome : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v =  inflater.inflate(R.layout.fragment_registration_complete_welcome, container, false)
        v.apply {
            val tvHeading: TextView = findViewById(R.id.tv_headingWelcomeAboard)
            val tvButtonText: TextView = findViewById(R.id.btn_BeginText)

            var gradient = listOf<TextView>(tvHeading,tvButtonText)
            MainActivity.textShader(gradient)

            val btnEnterMainFeed = findViewById<NeumorphButton>(R.id.btn_BeginJourney)
            btnEnterMainFeed.setOnClickListener {

                var sharedPreferences:SharedPreferences? = activity?.getSharedPreferences("UserScreenState",MODE_PRIVATE)
                if(sharedPreferences!=null){
                    var editor = sharedPreferences.edit()
                    editor.putInt("isRegistrationLoginDone",1)
                    editor.apply()
                }

                //Code to clear the backstack
                val count = parentFragmentManager.backStackEntryCount
                for(i in 0 until count)
                    parentFragmentManager.popBackStack()

                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.FragmentHolder, Fragment_MainScreen())
                    commit()
                }
            }
        }
        return v
    }

}