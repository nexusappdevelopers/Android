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
import com.nexus.codebase.model.SongDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SongRemoteDataSource(apiClient: ApiClient) : SongDataSource {

    private var call: Call<SongResponse>? = null
    private val service = apiClient.build()

    override fun retrieveSongs(callback: OperationCallback<Song>) {

        call = service?.Songs()
        call?.enqueue(object : Callback<SongResponse> {
            override fun onFailure(call: Call<SongResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<SongResponse>,
                response: Response<SongResponse>
            ) {
                response.body()?.let {
                    if (response.isSuccessful && (it.isSuccess())) {
                        callback.onSuccess(it.data)
                    } else {
                        callback.onError(it.msg)
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}