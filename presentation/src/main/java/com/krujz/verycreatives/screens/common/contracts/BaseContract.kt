package com.krujz.verycreatives.screens.common.contracts

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View {

    }
}