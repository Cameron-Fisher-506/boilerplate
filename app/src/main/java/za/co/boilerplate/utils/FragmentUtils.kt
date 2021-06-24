package za.co.boilerplate.utils

import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import za.co.boilerplate.R

object FragmentUtils {
    fun startFragment(fragmentManager: FragmentManager, fragment: Fragment?, containerId: Int, actionBar: ActionBar?, title: String?, isRequireReplace: Boolean, isRequireBackStack: Boolean, isRequireAnimation: Boolean, tag: String?) {
        val fragmentTransaction = fragmentManager.beginTransaction()

        if (isRequireAnimation) {
            fragmentTransaction.setCustomAnimations(R.anim.push_in_from_left, R.anim.push_out_to_right, R.anim.push_in_from_right, R.anim.push_out_to_left)
            //fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        }

        fragment?.let {
            if (isRequireReplace) {
                fragmentTransaction.replace(containerId, fragment)
            } else {
                fragmentTransaction.add(containerId, fragment)
            }
        }

        if (isRequireBackStack) {
            fragmentTransaction.addToBackStack(tag)
        }

        actionBar?.let {
            actionBar.title = title
        }

        fragmentTransaction.commit()
    }
}