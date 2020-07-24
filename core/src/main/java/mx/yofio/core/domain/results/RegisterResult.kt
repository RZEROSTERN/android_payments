package mx.yofio.core.domain.results

import com.google.gson.annotations.SerializedName

data class RegisterResult (
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("full_name")
    val full_name: String,
    @SerializedName("phone_number")
    val phone_number: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("status")
    val status: String
)