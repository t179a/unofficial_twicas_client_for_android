package com.example.unofficial_twicas_client_for_android

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://apiv2.twitcasting.tv"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TwicasApiService {
    @FormUrlEncoded
    @POST("oauth2/access_token")
    suspend fun getAccessToken(@FieldMap options: Map<String, String>): AuthorizationProperty


}

object TwicasApi {
    val retrofitService: TwicasApiService by lazy { retrofit.create(TwicasApiService::class.java) }
}

data class MarsProperty(
    val id: String,

    @Json(name = "img_src") val imgStrUrl: String,
    val type: String,
    val price: Double
)