package com.frogobox.recyclercoroutines

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


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

    val listMainData = MutableLiveData<MutableList<MainData>>()

    fun setupData(){
        val data = mutableListOf<MainData>()
        data.add(MainData("Faisal Amir", 24))
        listMainData.postValue(data)
    }

}