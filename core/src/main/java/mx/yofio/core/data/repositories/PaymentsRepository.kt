package mx.yofio.core.data.repositories

import io.reactivex.Observable
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.core.domain.results.MembershipPaymentsResult
import mx.yofio.core.domain.results.PaymentResult

interface PaymentsRepository {
    fun getPaymentsFromId(token: String, id: String): Observable<MutableList<MembershipPaymentsResult>>

    fun pay(token: String, paymentRequest: PaymentRequest): Observable<PaymentResult>
}