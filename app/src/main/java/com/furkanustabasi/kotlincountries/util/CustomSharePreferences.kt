package com.furkanustabasi.kotlincountries.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharePreferences {

    companion object {

        private val PREFERENCES_TIME = "preferences_time"
        private var sharePreferences: SharedPreferences? = null
        private val lock = Any()

        @Volatile
        private var instance: CustomSharePreferences? = null

        operator fun invoke(context: Context): CustomSharePreferences = instance ?: synchronized(lock) {
            instance ?: makeCustomSharePreferences(context).also {
                instance = it
            }
        }

        private fun makeCustomSharePreferences(context: Context): CustomSharePreferences {
            sharePreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharePreferences()
        }
    }

    fun saveTime(time: Long) {
        sharePreferences?.edit(commit = true) {
            putLong(PREFERENCES_TIME, time)
        }
    }

    fun getTime() = sharePreferences?.getLong(PREFERENCES_TIME, 0)

}