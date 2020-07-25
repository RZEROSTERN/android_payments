package mx.yofio.core.domain.requests

data class LoginRequest (
    var phone_number: String,
    var password: String
)