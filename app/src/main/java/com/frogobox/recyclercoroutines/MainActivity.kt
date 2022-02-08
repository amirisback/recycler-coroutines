package com.frogobox.recyclercoroutines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.recyclercoroutines.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), MainItemListener {

    private val mainViewModel: MainViewModel by viewModel()

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

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
        }
    }

    private fun setupRV(data: MutableList<MainData>) {
        val mainAdapter = MainAdapter(this)
        mainAdapter.setContent(data)

        binding.rvFrogo.apply {
            adapter = mainAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

    }

    override fun onClickListener(data: MainData) {
    }

}