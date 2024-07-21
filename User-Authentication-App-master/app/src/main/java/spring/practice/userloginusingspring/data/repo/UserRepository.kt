package spring.practice.userloginusingspring.data.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import spring.practice.userloginusingspring.data.api.ApiService
import spring.practice.userloginusingspring.data.model.UserData

class UserRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun createUser(userData: UserData): UserData {
        return apiService.createUser(
            userData.firstName,
            userData.lastName,
            userData.email,
            userData.password
        )
    }

}