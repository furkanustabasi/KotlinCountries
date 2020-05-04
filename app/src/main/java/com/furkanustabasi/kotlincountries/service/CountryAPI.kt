package com.furkanustabasi.kotlincountries.service

import com.furkanustabasi.kotlincountries.model.Country
import com.furkanustabasi.kotlincountries.viewmodel.CountryViewModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface CountryAPI {

//https://raw.githubusercontent.com/furkanustabasi/DummyData/master/countries.json

    @GET("furkanustabasi/DummyData/master/countries.json")
    fun getCountries() : Single<List<Country>>




}