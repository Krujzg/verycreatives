package com.krujz.verycreatives.dependencyinjection.app

import com.krujz.verycreatives.dependencyinjection.activity.ActivityComponent
import dagger.Component

@AppScope
@Component(modules = [NetworkingAppModule::class, /*ViewModelFactoryModule::class*/])
interface AppComponent {
   fun newActivityComponentBuilder() : ActivityComponent.Builder
}