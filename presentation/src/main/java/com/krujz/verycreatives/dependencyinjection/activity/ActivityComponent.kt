package com.krujz.verycreatives.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.krujz.verycreatives.dependencyinjection.activity.modules.*
import com.krujz.verycreatives.dependencyinjection.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [
    ActivityModule::class,
    UseCaseModule::class,
    MapperModule::class,
    RepositoryModule::class,
    ServiceModule::class,
    FragmentModule::class]
)
interface ActivityComponent {
    fun newPresentationComponent() : PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity) : Builder
        fun activityModule(activityModule: ActivityModule) : Builder
        fun useCaseModule(useCaseModule: UseCaseModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun serviceModule(serviceModule: ServiceModule) : Builder
        fun mapperModule(mapperModule: MapperModule): Builder
        fun fragmentModule(fragmentModule: FragmentModule): Builder
        fun build() : ActivityComponent
    }
}