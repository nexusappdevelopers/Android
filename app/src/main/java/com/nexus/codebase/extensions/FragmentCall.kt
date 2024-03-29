/*
 *
 *  * @copyright : Nexus App Developers. < https://www.nexusappdevelopers.com >
 *  * @author     : Elliot
 *  *
 *  * All Rights Reserved.
 *  * Proprietary and confidential :  All information contained herein is, and remains
 *  * the property of Nexus App Developers and its partners.
 *  * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 */

package com.nexus.codebase.extensions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


fun AppCompatActivity.replaceFragment(fragment: androidx.fragment.app.Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        replace(frameId, fragment).addToBackStack(fragment.javaClass.name)
    }
}

fun AppCompatActivity.replaceFragWithArgs(
    fragment: androidx.fragment.app.Fragment,
    frameId: Int,
    args: Bundle
) {
    fragment.arguments = args
    supportFragmentManager.inTransaction {
        replace(frameId, fragment).addToBackStack(fragment.javaClass.name)
    }
}

fun androidx.fragment.app.FragmentManager.inTransaction(func: androidx.fragment.app.FragmentTransaction.() -> androidx.fragment.app.FragmentTransaction) {
    beginTransaction().func().commit()
}

fun AppCompatActivity.addFragment(
    fragment: androidx.fragment.app.Fragment,
    frameId: Int,
    backStackTag: String? = null
) {
    supportFragmentManager.inTransaction {
        add(frameId, fragment)
        backStackTag?.let {
            addToBackStack(fragment.javaClass.name)
        }!!
    }
}