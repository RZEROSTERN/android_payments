package mx.yofio.core.domain.results

import com.google.gson.annotations.SerializedName

data class MembershipPaymentsResult (
    @SerializedName("id")
    val id: String,
    @SerializedName("message")
    val customer_id: String,
    @SerializedName("amount")
    val amount: Float
)