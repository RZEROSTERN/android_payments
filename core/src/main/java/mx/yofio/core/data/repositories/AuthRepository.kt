package mx.yofio.core.data.repositories

import io.reactivex.Observable
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult

interface AuthRepository {
    fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>
}