package com.example.deliveryshareapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.deliveryshareapp.databinding.ActivityNaviBinding

private const val TAG_HOME = "home_fragment"
private const val TAG_CHAT = "chat_fragment"
private const val TAG_MYPAGE = "mypage_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_navi)

        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_home -> setFragment(TAG_HOME, HomeFragment())
                R.id.navigation_chat -> setFragment(TAG_CHAT, ChatFragment())
                R.id.navigation_mypage-> setFragment(TAG_MYPAGE, MypageFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mypage_account_layout, fragment, tag)
        }

        val home = manager.findFragmentByTag(TAG_HOME)
        val chat = manager.findFragmentByTag(TAG_CHAT)
        val mypage = manager.findFragmentByTag(TAG_MYPAGE)

        if (chat != null){
            fragTransaction.hide(chat)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (mypage != null) {
            fragTransaction.hide(mypage)
        }

        if (tag == TAG_CHAT) {
            if (chat!=null){
                fragTransaction.show(chat)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_MYPAGE){
            if (mypage != null){
                fragTransaction.show(mypage)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}