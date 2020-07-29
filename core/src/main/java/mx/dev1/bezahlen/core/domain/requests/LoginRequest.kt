package mx.dev1.bezahlen.core.domain.requests

data class LoginRequest (
    var phone_number: String,
    var password: String
)