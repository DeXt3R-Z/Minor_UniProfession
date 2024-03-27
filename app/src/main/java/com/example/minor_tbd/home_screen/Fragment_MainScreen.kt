package com.example.minor_tbd.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.minor_tbd.MainActivity
import com.example.minor_tbd.R
import com.example.minor_tbd.chat_screen.Fragment_Chat_Screen
import com.example.minor_tbd.leaderboard.Fragment_Leaderboard
import com.example.minor_tbd.onboarding_screens.Fragment_1_GreetingScreen
import com.google.firebase.auth.FirebaseAuth

class Fragment_MainScreen : Fragment() {
    private lateinit var btnHomeTab: View
    private lateinit var btnChatTab: View
    private lateinit var btnProfileTab: View
    private lateinit var btnLeaderboardTab: View
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val v = inflater.inflate(R.layout.fragment_main_screen, container, false)
         v.apply {
             btnHomeTab = findViewById(R.id.btn_HomeTab)
             btnChatTab = findViewById(R.id.btn_ChatTab)
             btnLeaderboardTab = findViewById(R.id.btn_Leaderboard)
             btnProfileTab = findViewById(R.id.btn_ProfileTab)

             val appName = findViewById<TextView>(R.id.tv_AppName)

             val textGradient = listOf<TextView>(appName)
             MainActivity.textShader(textGradient)

             btnHomeTab.setOnClickListener {
                 parentFragmentManager.beginTransaction().apply {
//                     addToBackStack("Chat Tab")
                     replace(R.id.Fragment_NavBar_Tab_layout_holder, Fragment_Feed()).commit()
                 }
             }

             btnChatTab.setOnClickListener {
                 parentFragmentManager.beginTransaction().apply {
//                     addToBackStack("Chat Tab")
                     replace(R.id.Fragment_NavBar_Tab_layout_holder, Fragment_Chat_Screen()).commit()
                 }
             }

             btnLeaderboardTab.setOnClickListener {
                 parentFragmentManager.beginTransaction().apply {
//                     addToBackStack("Chat Tab")
                     replace(R.id.Fragment_NavBar_Tab_layout_holder, Fragment_Leaderboard()).commit()
                 }
             }

             btnProfileTab.setOnClickListener {
                 FirebaseAuth.getInstance().signOut()
                 parentFragmentManager.beginTransaction().apply {
                     replace(R.id.FragmentHolder, Fragment_1_GreetingScreen()).commit()
                 }
             }


         }
         parentFragmentManager.beginTransaction().apply {
             replace(R.id.Fragment_NavBar_Tab_layout_holder, Fragment_Feed())
             commit()
         }
         return v
    }

}