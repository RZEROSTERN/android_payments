package mx.dev1.bezahlen.core.interactors

import io.reactivex.Observable
import mx.dev1.bezahlen.core.domain.requests.PaymentRequest
import mx.dev1.bezahlen.core.domain.results.MembershipPaymentsResult
import mx.dev1.bezahlen.core.domain.results.PaymentResult

interface PaymentsInteractor {
    fun getPaymentsById(token: String, id: String): Observable<MutableList<MembershipPaymentsResult>>

    fun pay(token: String, paymentRequest: PaymentRequest): Observable<PaymentResult>
}