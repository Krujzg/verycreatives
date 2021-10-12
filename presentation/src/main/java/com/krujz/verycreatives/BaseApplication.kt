package com.krujz.verycreatives

import android.app.Application
import com.krujz.verycreatives.dependencyinjection.app.AppComponent
import com.krujz.verycreatives.dependencyinjection.app.DaggerAppComponent
import com.krujz.verycreatives.dependencyinjection.app.NetworkingAppModule

class BaseApplication : Application() {
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.builder()
            .networkingAppModule(NetworkingAppModule(this))
            .build()
    }
}