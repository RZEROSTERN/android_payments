package mx.dev1.bezahlen.core.data.repositories

import io.reactivex.Observable
import mx.dev1.bezahlen.core.data.network.RestApi
import mx.dev1.bezahlen.core.data.network.RestApiImp
import mx.dev1.bezahlen.core.domain.requests.LoginRequest
import mx.dev1.bezahlen.core.domain.requests.UserRegisterRequest
import mx.dev1.bezahlen.core.domain.results.LoginResult
import mx.dev1.bezahlen.core.domain.results.RegisterResult

class AuthRepositoryImp: AuthRepository {
    private var apiRequest: RestApi = RestApiImp.getClient().create(RestApi::class.java)

    override fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult> {
        return apiRequest.register(registerRequest)
    }

    override fun login(loginRequest: LoginRequest): Observable<LoginResult> {
        return apiRequest.login(loginRequest)
    }
}