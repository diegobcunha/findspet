package com.diegocunha

import android.app.Application
import com.diegocunha.commons.coroutines.coroutineModule
import com.diegocunha.datasource.dataModule
import com.diegocunha.discoverypet.injection.discoveryPetModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FindPetApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@FindPetApplication)
            modules(
                dataModule,
                discoveryPetModule,
                coroutineModule
            )
        }
    }
}