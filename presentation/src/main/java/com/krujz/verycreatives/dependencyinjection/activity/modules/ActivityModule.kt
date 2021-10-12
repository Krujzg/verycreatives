package com.krujz.verycreatives.dependencyinjection.activity.modules

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {

    @Provides
    fun layoutInflater(activity: AppCompatActivity) : LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) : FragmentManager = activity.supportFragmentManager

    /*@Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity) : IScreensNavigator = ScreensNavigator(activity)

    @Provides
    @ActivityScope
    fun imageLoader(activity: AppCompatActivity) : IImageLoader = ImageLoader(activity)

    @Provides
    fun dialogNavigator(fragmentManager: FragmentManager) : IDialogNavigator = DialogNavigator(fragmentManager)

    @Provides
    @ActivityScope
    fun viewMvcFactory(layoutInflater: LayoutInflater,imageLoader: IImageLoader, dialogNavigator: IDialogNavigator, screensNavigator: IScreensNavigator): IViewMvcFactory
        = ViewMvcFactory(layoutInflater, imageLoader, dialogNavigator, screensNavigator)*/
}