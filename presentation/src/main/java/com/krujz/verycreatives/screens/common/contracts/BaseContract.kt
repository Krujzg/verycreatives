package com.krujz.verycreatives.screens.common.contracts

interface BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {

    }
}