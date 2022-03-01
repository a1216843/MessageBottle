package com.example.messagebottle.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.messagebottle.R
import com.example.messagebottle.data.model.UserModel
import com.example.messagebottle.data.model.mapToPresentation
import com.example.messagebottle.data.remote.ApiProvider.UserApi
import com.example.messagebottle.databinding.ActivityMainBinding
import com.example.messagebottle.ui.item.UserItem
import com.example.messagebottle.ui.navigation.ReceiveFragment
import com.example.messagebottle.ui.navigation.StorageFragment
import com.example.messagebottle.ui.navigation.UserFragment
import com.example.messagebottle.ui.navigation.WriteFragment
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var user_info : UserItem? = null
    var result : UserModel? = null
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initMainFragment()
        binding.bottomNav.setOnItemSelectedListener(this)
        CoroutineScope(Dispatchers.Main).launch {
            var result = UserApi.getUser("Test_User")
            initUserInfo(result, baseContext)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId) {
                R.id.action_user -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.content.id, UserFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
                    return true
                }
                R.id.action_write -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.content.id, WriteFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
                    return true
                }
                R.id.action_receive -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.content.id, ReceiveFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
                    return true
                }
                R.id.action_storage -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(binding.content.id, StorageFragment.newInstance())
                        .addToBackStack(null)
                        .commit()
                    return true
                }
            }
        return false
    }
    fun initUserInfo(info : UserModel?, context: Context) {
        user_info = info?.mapToPresentation(context)
    }
    private fun initMainFragment() {
        supportFragmentManager.beginTransaction()
            .add(binding.content.id, UserFragment.newInstance())
            .commit()
    }
    fun goToWriteFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.content.id, WriteFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }
}
