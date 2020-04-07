package com.achie.ins.ui.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.achie.ins.R

class HomeViewModel : ViewModel() {

    private val _installerMessageLD = MutableLiveData<String>()

    val installerMessageLD: LiveData<String> = _installerMessageLD

    fun fetchInstallerLocation(context: Context) =
        with(context) {
            val appPackage = applicationContext.packageName
            val installerPackage = packageManager.getInstallerPackageName(appPackage)
            val installerMessage = getString(R.string.installer_message_prefix, installerPackage)
            _installerMessageLD.postValue(installerMessage)
        }

}
