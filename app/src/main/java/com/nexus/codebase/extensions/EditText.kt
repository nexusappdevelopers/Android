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

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView


fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })


}


fun EditText.isBlank(): Boolean {
    return this.text.isEmpty()
}


fun EditText.getLength(): Int {
    return this.text.toString().length
}

fun EditText.checkString(): String {
    return this.text.toString().trim()
}


fun TextView.isBlank(): Boolean {
    return this.text.isEmpty()
}

fun TextView.checkString(): String {
    return this.text.toString().trim()
}

