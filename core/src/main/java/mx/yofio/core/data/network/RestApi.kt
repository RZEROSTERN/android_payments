package mx.yofio.core.data.network

import io.reactivex.Observable
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi {
    @POST("customer")
    fun register(@Body registerRequest: UserRegisterRequest): Observable<RegisterResult>
}