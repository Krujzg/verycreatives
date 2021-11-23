package com.krujz.verycreatives.screens.common.fragment

import androidx.fragment.app.Fragment
import com.krujz.verycreatives.screens.common.activity.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

open class BaseFragment : Fragment() {
    protected val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    protected val coroutineScopeIO = CoroutineScope(SupervisorJob() + Dispatchers.IO)

}