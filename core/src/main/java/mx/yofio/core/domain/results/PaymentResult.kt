package mx.yofio.core.domain.results

import com.google.gson.annotations.SerializedName

data class PaymentResult (
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("customer_id")
    val customer_id: String,
    @SerializedName("amount")
    val amount: Float
)