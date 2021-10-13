package com.krujz.verycreatives.dependencyinjection.activity.modules

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.krujz.verycreatives.dependencyinjection.activity.ActivityScope
import com.krujz.verycreatives.screens.common.contracts.MainContract
import com.krujz.verycreatives.screens.common.dialogs.DialogNavigator
import com.krujz.verycreatives.screens.common.dialogs.interfaces.IDialogNavigator
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.screens.common.imageloader.ImageLoader
import com.krujz.verycreatives.screens.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
object ActivityModule {

    @Provides
    fun layoutInflater(activity: AppCompatActivity) : LayoutInflater = LayoutInflater.from(activity)

    @Provides
    fun fragmentManager(activity: AppCompatActivity) : FragmentManager = activity.supportFragmentManager

    @Provides
    @ActivityScope
    fun imageLoader(activity: AppCompatActivity) : IImageLoader = ImageLoader(activity)

    @Provides
    @ActivityScope
    fun mainPresenter(): MainContract.Presenter{
        return MainPresenter()
    }

}