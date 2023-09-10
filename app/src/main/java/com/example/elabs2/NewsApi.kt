package com.example.elabs2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val Base_url="https://newsapi.org/"
const val KEY="d5546036179d40de9754d1b4e0defa53"
interface NewsApi{
    @GET("v2/top-headLines?apiKey=d5546036179d40de9754d1b4e0defa53")
    fun getheadlines(@Query("country")country:String,@Query("page")page:Int): Call<news>

}

object newservices{
    var newsinstance:NewsApi
    init {
        var retrofit=Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance=retrofit.create(NewsApi::class.java)
    }
}