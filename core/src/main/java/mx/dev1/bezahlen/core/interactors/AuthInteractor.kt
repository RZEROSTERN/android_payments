package mx.dev1.bezahlen.core.interactors

import io.reactivex.Observable
import mx.dev1.bezahlen.core.domain.requests.LoginRequest
import mx.dev1.bezahlen.core.domain.requests.UserRegisterRequest
import mx.dev1.bezahlen.core.domain.results.LoginResult
import mx.dev1.bezahlen.core.domain.results.RegisterResult

interface AuthInteractor {
    fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>?

    fun login(loginRequest: LoginRequest): Observable<LoginResult>?
}