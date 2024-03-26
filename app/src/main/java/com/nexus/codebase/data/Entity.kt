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

package com.nexus.codebase.data

import com.nexus.codebase.model.Song


data class SongResponse(val status: Int?, val msg: String?, val data: List<Song>?) {
    fun isSuccess(): Boolean = (status == 200)
}