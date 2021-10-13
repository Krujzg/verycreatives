package com.krujz.verycreatives.dependencyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.krujz.verycreatives.dependencyinjection.activity.modules.*
import com.krujz.verycreatives.dependencyinjection.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class,FragmentModule::class, UseCaseModule::class, MapperModule::class, RepositoryModule::class])
interface ActivityComponent {
    fun newPresentationComponent() : PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity) : Builder
        fun activityModule(activityModule: ActivityModule) : Builder
        fun useCaseModule(useCaseModule: UseCaseModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun mapperModule(mapperModule: MapperModule): Builder
        fun fragmentModule(fragmentModule: FragmentModule): Builder
        fun build() : ActivityComponent
    }
}