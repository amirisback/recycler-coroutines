package com.frogobox.recyclercoroutines

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
 * Created by faisalamir on 08/02/22
 * recyclercoroutines
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Mona Primaveras Inc.      
 * All rights reserved
 *
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val data = mutableListOf<MainData>()
    val listMainData = MutableLiveData<MutableList<MainData>>()

    fun setupData() {
        data.add(MainData("Faisal Amir", 24))
        listMainData.postValue(data)
    }

    fun repeater(adapter: MainAdapter) {
        viewModelScope.launch {
            repeat(10) { i -> // launch a lot of coroutines
                delay(1000L)
                Log.d("Coroutines", "Repeat $i")
                adapter.notifyInserted(MainData("Repeater", i), i+1)
            }

        }
    }

}