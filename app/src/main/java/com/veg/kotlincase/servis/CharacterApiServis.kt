package com.veg.kotlincase.servis


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.veg.kotlincase.model.CharacterModel
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



private const val  BASE_URL="https://jsonplaceholder.typicode.com/"

private val moshi= Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit=Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

interface CharacterApiServis{
    @GET("users")
    suspend fun getCharacter():List<CharacterModel>


}

object CharacterApi{
    val retrofitService:CharacterApiServis by lazy {
        retrofit.create(CharacterApiServis::class.java)
    }
}

