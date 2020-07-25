package mx.yofio.core.domain.requests

import mx.yofio.core.domain.CreditCard

data class PaymentRequest (
    var customer_id: String,
    var amount: Float,
    var credit_card_data: CreditCard
)