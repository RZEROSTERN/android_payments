package mx.dev1.bezahlen.core.data.repositories

import io.reactivex.Observable
import mx.dev1.bezahlen.core.domain.requests.PaymentRequest
import mx.dev1.bezahlen.core.domain.results.MembershipPaymentsResult
import mx.dev1.bezahlen.core.domain.results.PaymentResult

interface PaymentsRepository {
    fun getPaymentsFromId(token: String, id: String): Observable<MutableList<MembershipPaymentsResult>>

    fun pay(token: String, paymentRequest: PaymentRequest): Observable<PaymentResult>
}