package mx.yofio.core.interactors

import io.reactivex.Observable
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.core.domain.results.MembershipPaymentsResult
import mx.yofio.core.domain.results.PaymentResult

interface PaymentsInteractor {
    fun getPaymentsById(token: String, id: String): Observable<MutableList<MembershipPaymentsResult>>

    fun pay(token: String, paymentRequest: PaymentRequest): Observable<PaymentResult>
}