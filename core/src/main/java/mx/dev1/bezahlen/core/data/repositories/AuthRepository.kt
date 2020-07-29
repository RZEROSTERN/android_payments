package mx.dev1.bezahlen.core.data.repositories

import io.reactivex.Observable
import mx.dev1.bezahlen.core.domain.requests.LoginRequest
import mx.dev1.bezahlen.core.domain.requests.UserRegisterRequest
import mx.dev1.bezahlen.core.domain.results.LoginResult
import mx.dev1.bezahlen.core.domain.results.RegisterResult

interface AuthRepository {
    fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>

    fun login(loginRequest: LoginRequest): Observable<LoginResult>
}