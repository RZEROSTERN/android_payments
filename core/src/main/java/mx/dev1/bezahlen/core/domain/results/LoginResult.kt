package mx.dev1.bezahlen.core.domain.results

import com.google.gson.annotations.SerializedName

data class LoginResult (
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("token")
    val token: String
)