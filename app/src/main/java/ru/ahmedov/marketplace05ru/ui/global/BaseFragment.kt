package ru.ahmedov.marketplace05ru.ui.global

import moxy.MvpAppCompatFragment

abstract class BaseFragment : MvpAppCompatFragment() {

    abstract fun onBackPressed()
}
