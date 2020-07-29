package mx.dev1.bezahlen.presentation

import mx.bezahlen.core.domain.requests.LoginRequest
import mx.bezahlen.core.domain.requests.PaymentRequest
import mx.bezahlen.core.domain.requests.UserRegisterRequest
import mx.bezahlen.core.interactors.AuthInteractor
import mx.bezahlen.core.interactors.PaymentsInteractor

class ApiDependencies(private var authInteractor: AuthInteractor,
                      private var paymentsInteractor: PaymentsInteractor) {
    fun register(userRegisterRequest: UserRegisterRequest) = authInteractor.register(userRegisterRequest)
    fun login(loginRequest: LoginRequest) = authInteractor.login(loginRequest)
    fun getPaymentsById(token: String, id: String) = paymentsInteractor.getPaymentsById(token, id)
    fun pay(token: String, paymentRequest: PaymentRequest) = paymentsInteractor.pay(token, paymentRequest)
}