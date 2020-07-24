package mx.yofio.core.data.network

import io.reactivex.Observable
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult
import retrofit2.http.POST

interface RestApi {
    @POST("/register/customer")
    fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>
}