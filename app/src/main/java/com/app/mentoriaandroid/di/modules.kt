package com.app.mentoriaandroid.di

import com.app.mentoriaandroid.data.datasource.GetCharacterRemoteDataSource
import com.app.mentoriaandroid.data.datasource.GetCharacterRemoteDataSourceImpl
import com.app.mentoriaandroid.data.repository.GetCharacterRepositoryImpl
import com.app.mentoriaandroid.data.retrofit.getInstance
import com.app.mentoriaandroid.data.service.HarryPotterService
import com.app.mentoriaandroid.domain.repository.GetCharacterRepository
import com.app.mentoriaandroid.domain.usecase.GetCharacterUseCase
import com.app.mentoriaandroid.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val harryPotterModules = module {
    factory { getInstance() }
    factory { get<Retrofit>().create(HarryPotterService::class.java) }
    factory<GetCharacterRepository> { GetCharacterRepositoryImpl(get()) }
    factory<GetCharacterRemoteDataSource> { GetCharacterRemoteDataSourceImpl(get()) }
    factory { GetCharacterUseCase(get()) }
    viewModel { HomeViewModel(get()) }
}
