package spring.practice.userloginusingspring.data.model

import java.time.LocalDateTime

data class UserData (
    val userId:Long?=null,
    val firstName:String,
    val lastName:String,
    val email:String,
    val password:String,
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
)