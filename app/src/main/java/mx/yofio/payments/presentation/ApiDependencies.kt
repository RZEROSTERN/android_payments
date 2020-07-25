package mx.yofio.payments.presentation

import mx.yofio.core.domain.requests.LoginRequest
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.interactors.AuthInteractor
import mx.yofio.core.interactors.PaymentsInteractor

class ApiDependencies(private var authInteractor: AuthInteractor,
                      private var paymentsInteractor: PaymentsInteractor) {
    fun register(userRegisterRequest: UserRegisterRequest) = authInteractor.register(userRegisterRequest)
    fun login(loginRequest: LoginRequest) = authInteractor.login(loginRequest)
    fun getPaymentsById(token: String, id: String) = paymentsInteractor.getPaymentsById(token, id)
    fun pay(token: String, paymentRequest: PaymentRequest) = paymentsInteractor.pay(token, paymentRequest)
}