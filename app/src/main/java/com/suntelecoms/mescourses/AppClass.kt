package com.suntelecoms.mescourses

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.suntelecoms.mescourses.helpers.IOnBackPressed
import java.util.*

class AppClass : Application() {


    val backPressListeners: Stack<IOnBackPressed> = Stack()

    var isSynchro: Boolean = true

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())


        appInstance = this
    }


    companion object {
        private lateinit var appInstance: AppClass
        var isDeviceConnected = false
        var isDeviceBackground = false

        fun getAppInstance(): AppClass {
            return appInstance
        }


        const val CHANNEL_ID = "AichaWalle"
        const val CHANNEL_NAME = "AichaWalleOne"
        const val BUNDLE_CHANNEL_ID = "AichaOne"
        const val BUNDLE_CHANNEL_NAME = "AichaGroup"
        const val SUMMARY_ID = 0
    }

}