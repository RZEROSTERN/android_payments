package mx.yofio.core.data.repositories

import io.reactivex.Observable
import mx.yofio.core.data.network.RestApi
import mx.yofio.core.data.network.RestApiImp
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult

class AuthRepositoryImp: AuthRepository {
    private var apiRequest: RestApi = RestApiImp.getClient().create(RestApi::class.java)

    override fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult> {
        return apiRequest.register(registerRequest)
    }

}