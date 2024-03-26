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

package com.nexus.codebase.di

import androidx.lifecycle.ViewModelProvider
import com.nexus.codebase.data.ApiClient
import com.nexus.codebase.data.SongRemoteDataSource
import com.nexus.codebase.model.SongDataSource
import com.nexus.codebase.model.SongRepository
import com.nexus.codebase.viewmodel.ViewModelFactory


object Injection {

    private var SongDataSource: SongDataSource? = null
    private var SongRepository: SongRepository? = null
    private var SongViewModelFactory: ViewModelFactory? = null

    private fun createSongDataSource(): SongDataSource {
        val dataSource = SongRemoteDataSource(ApiClient)
        SongDataSource = dataSource
        return dataSource
    }

    private fun createSongRepository(): SongRepository {
        val repository = SongRepository(provideDataSource())
        SongRepository = repository
        return repository
    }

    private fun createFactory(): ViewModelFactory {
        val factory = ViewModelFactory(providerRepository())
        SongViewModelFactory = factory
        return factory
    }

    private fun provideDataSource() = SongDataSource ?: createSongDataSource()
    private fun providerRepository() = SongRepository ?: createSongRepository()

    fun provideViewModelFactory() = SongViewModelFactory ?: createFactory()

    fun destroy() {
        SongDataSource = null
        SongRepository = null
        SongViewModelFactory = null
    }
}