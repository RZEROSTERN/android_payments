package mx.yofio.core.domain

data class CreditCard (
    var number: String,
    var expiration_date: String,
    var cardholder_name: String,
    var cvv: String
)