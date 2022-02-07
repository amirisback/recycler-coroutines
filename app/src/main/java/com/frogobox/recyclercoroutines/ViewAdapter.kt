package com.frogobox.recyclercoroutines

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/*
 * Created by faisalamir on 07/02/22
 * recyclercoroutines
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 FrogoBox Inc.      
 * All rights reserved
 *
 */

class ViewAdapter : RecyclerView.Adapter<ViewHolder>(){

    private val listData = mutableListOf<ExampleData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}