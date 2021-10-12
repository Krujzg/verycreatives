package com.krujz.verycreatives.screens.common.dialogs

import androidx.fragment.app.DialogFragment
import com.krujz.verycreatives.screens.common.activity.BaseActivity

open class BaseDialog : DialogFragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    protected val injector get() = presentationComponent
}