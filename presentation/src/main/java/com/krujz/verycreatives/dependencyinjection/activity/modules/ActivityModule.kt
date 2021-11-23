package com.krujz.verycreatives.dependencyinjection.activity.modules

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.krujz.verycreatives.screens.common.contracts.MainContract
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.screens.common.imageloader.ImageLoader
import com.krujz.verycreatives.screens.main.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {


    @Provides
    fun appCompatActivity(activity: Activity) : AppCompatActivity = activity as AppCompatActivity

    @Provides
    fun layoutInflater(activity: AppCompatActivity) : LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) : FragmentManager = activity.supportFragmentManager

    @Provides
    @ActivityScoped
    fun imageLoader(activity: AppCompatActivity) : IImageLoader = ImageLoader(activity)

    @Provides
    @ActivityScoped
    fun mainPresenter(): MainContract.Presenter{
        return MainPresenter()
    }

}