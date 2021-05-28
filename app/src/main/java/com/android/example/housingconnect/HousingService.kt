package com.android.example.housingconnect

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface HousingService {
    // TODO: PHASE 2.3 - Define GET "housing/all" endpoint
    //      returns a list of Posts
    @GET("housing/all")
    fun getAll(): Call<List<Post>>


    // TODO: PHASE 2.3 - Define POST "housing" endpoint
    //      returns a Message
    @POST("housing")
    fun create(@Body post: Post): Call<Message>

    // TODO: PHASE 2.3 - Define POST "images/upload" endpoint
    //      returns an ImageUploadResponse
    @Multipart
    @POST("images/upload")
    fun uploadImage(@Part image: MultipartBody.Part): Call<ImageUploadResponse>

    // NOTE: Don't need to define "/images/{id}" endpoint, Glide will handle that for us
}
