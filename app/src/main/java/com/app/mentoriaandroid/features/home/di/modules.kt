package com.app.mentoriaandroid.features.home.di

import com.app.mentoriaandroid.features.detail.domain.DetailUseCase
import com.app.mentoriaandroid.features.detail.presentation.viewmodel.DetailViewModel
import com.app.mentoriaandroid.features.home.data.datasource.GetCharacterRemoteDataSource
import com.app.mentoriaandroid.features.home.data.datasource.GetCharacterRemoteDataSourceImpl
import com.app.mentoriaandroid.features.home.data.repository.GetCharacterRepositoryImpl
import com.app.mentoriaandroid.features.home.data.service.HarryPotterService
import com.app.mentoriaandroid.features.home.domain.repository.GetCharacterRepository
import com.app.mentoriaandroid.features.home.domain.usecase.GetCharacterUseCase
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

fun harryPotterModules() = module {
    factory<GetCharacterRepository> { GetCharacterRepositoryImpl(get()) }
    factory<GetCharacterRemoteDataSource> { GetCharacterRemoteDataSourceImpl(get()) }
    factory { GetCharacterUseCase(get()) }
    factory { DetailUseCase() }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    factory { get<Retrofit>().create(HarryPotterService::class.java) }
}
