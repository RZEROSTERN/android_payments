package mx.yofio.core.data.repositories

import io.reactivex.Observable
import mx.yofio.core.domain.requests.LoginRequest
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.LoginResult
import mx.yofio.core.domain.results.RegisterResult

interface AuthRepository {
    fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>

    fun login(loginRequest: LoginRequest): Observable<LoginResult>
}