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

package com.nexus.codebase.model

import com.nexus.codebase.data.OperationCallback


class SongRepository(private val SongDataSource: SongDataSource) {

    fun fetchSongs(callback: OperationCallback<Song>) {
        SongDataSource.retrieveSongs(callback)
    }

    fun cancel() {
        SongDataSource.cancel()
    }
}