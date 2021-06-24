package za.co.boilerplate

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import za.co.boilerplate.databinding.ActivityMainBinding
import za.co.boilerplate.policies.PrivacyPolicyFrag
import za.co.boilerplate.utils.*

class MainActivity : AppCompatActivity(), WSCallsUtilsTaskCaller {
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        wireUI()
        displayPrivacyPolicy()
    }

    private fun displayPrivacyPolicy() {
        try {
            val jsonObject = SharedPreferencesUtils.get(this, SharedPreferencesUtils.PRIVACY_POLICY_ACCEPTANCE)
            if (jsonObject == null) {
                setNavIcons(false, false)
                val privacyPolicyFrag = PrivacyPolicyFrag()
                FragmentUtils.startFragment(supportFragmentManager, privacyPolicyFrag, R.id.fragmentContainer, supportActionBar, "Privacy Policy", true, false, true, null)
            } else {
            }
        } catch (e: Exception) {
            Log.e(ConstantUtils.TAG, "Error: ${e.message} " +
                    "Method: MainActivity - displayPrivacyPolicy " +
                    "CreatedTime: ${DTUtils.getCurrentDateTime()}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun wireUI() {
        val toolbar = findViewById<View>(R.id.app_bar) as Toolbar
        setSupportActionBar(toolbar)
    }

    fun setNavIcons(home: Boolean, menu: Boolean) {
        if (home) {
        } else {
        }
        if (menu) {
        } else {
        }
    }

    override fun taskCompleted(response: String?, reqCode: Int) {
        if (response != null) {
        }
    }

    override val activity: Activity?
        get() = TODO("Not yet implemented")
}