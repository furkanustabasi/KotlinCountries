package com.furkanustabasi.kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.furkanustabasi.kotlincountries.model.Country

@Dao
interface CountryDAO {

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>

    //Insert -> INSERT INTO
    //suspend -> coroutine, pause & resume
    //vararg -> multiple country object
    //list<Long> -> primary keys


    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId: Int): Country

    @Query("Delete FROM country")
    suspend fun deleteAllCountries()

}