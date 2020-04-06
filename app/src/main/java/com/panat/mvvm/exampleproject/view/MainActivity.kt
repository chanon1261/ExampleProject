package com.panat.mvvm.exampleproject.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.panat.mvvm.exampleproject.adapter.GitEventsAdapter
import com.panat.mvvm.exampleproject.databinding.ActivityMainBinding
import com.panat.mvvm.exampleproject.viewModel.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = innitRecyclerView()

        viewModel.events.observe(this, Observer {
            adapter.loadData(it)
        })
    }

    private fun innitRecyclerView(): GitEventsAdapter {
        val adapter = GitEventsAdapter(this)
        binding.rvEvent.layoutManager = LinearLayoutManager(this)
        binding.rvEvent.adapter = adapter
        return adapter
    }
}
