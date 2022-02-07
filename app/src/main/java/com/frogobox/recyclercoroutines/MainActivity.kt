package com.frogobox.recyclercoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.recyclercoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainItemListener {

    private val data = mutableListOf<MainData>()

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRV()
    }

    fun setupData(): MutableList<MainData> {
        data.add(MainData("Faisal Amir", 24))
        return data
    }

    fun setupRV() {
        val mainAdapter = MainAdapter(this)
        mainAdapter.setContent(setupData())

        binding.rvFrogo.apply {
            adapter = mainAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

    }

    override fun onClickListener(data: MainData) {
    }


}