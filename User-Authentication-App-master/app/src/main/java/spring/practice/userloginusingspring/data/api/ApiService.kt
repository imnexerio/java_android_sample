package spring.practice.userloginusingspring.data.api

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import spring.practice.userloginusingspring.data.model.UserData

interface ApiService {
    @POST("user/register")
    suspend fun createUser(
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("email") email:String,
        @Query("password") password:String
    ): UserData
}