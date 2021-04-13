package com.test.zoo.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * A ViewModelProvider with extra string param
 */
class ZooModelFactory(val app: Application, private val value: String): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ZooViewModel(app, value) as T

    }
}