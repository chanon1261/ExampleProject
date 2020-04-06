package com.panat.mvvm.exampleproject.di

import com.panat.mvvm.exampleproject.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    viewModel { MainViewModel(get()) }
}
