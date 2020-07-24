package mx.yofio.core.interactors

import io.reactivex.Observable
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult

interface AuthInteractor {
    fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>
}