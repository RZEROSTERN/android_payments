package mx.yofio.payments.presentation

import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.interactors.AuthInteractor

class ApiDependencies(var authInteractor: AuthInteractor) {
    fun register(userRegisterRequest: UserRegisterRequest) = authInteractor.register(userRegisterRequest)
}