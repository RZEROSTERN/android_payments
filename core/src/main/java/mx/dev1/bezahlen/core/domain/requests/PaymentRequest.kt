package mx.dev1.bezahlen.core.domain.requests

import mx.dev1.bezahlen.core.domain.CreditCard

data class PaymentRequest (
    var customer_id: String,
    var amount: Float,
    var credit_card_data: CreditCard
)