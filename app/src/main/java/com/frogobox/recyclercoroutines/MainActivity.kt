package com.frogobox.recyclercoroutines

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.recyclercoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), MainItemListener {

    private val mainViewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainAdapter = MainAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        mainViewModel.apply {
            setupData()
            listMainData.observe(this@MainActivity) {
                setupRV(it)
            }
            repeater(mainAdapter)
        }
    }

    private fun setupRV(it: MutableList<MainData>) {
        mainAdapter.setContent(it)
        binding.rvFrogo.apply {
            adapter = mainAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, true)
        }
    }

    override fun onClickListener(data: MainData) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }

    fun repeater(adapter: MainAdapter) {
        lifecycleScope.launch {
            repeat(10) { i -> // launch a lot of coroutines
                delay(1000L)
                Log.d("Coroutines", "Repeat $i")
                adapter.notifyInserted(MainData("Repeater", i), i+1)
            }

        }
    }


}