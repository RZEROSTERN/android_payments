package mx.dev1.bezahlen.core.data.repositories

import io.reactivex.Observable
import mx.dev1.bezahlen.core.data.network.RestApi
import mx.dev1.bezahlen.core.data.network.RestApiImp
import mx.dev1.bezahlen.core.domain.requests.PaymentRequest
import mx.dev1.bezahlen.core.domain.results.MembershipPaymentsResult
import mx.dev1.bezahlen.core.domain.results.PaymentResult

class PaymentsRepositoryImp: PaymentsRepository {
    private var apiRequest: RestApi = RestApiImp.getClient().create(RestApi::class.java)

    override fun getPaymentsFromId(
        token: String,
        id: String
    ): Observable<MutableList<MembershipPaymentsResult>> {
        return apiRequest.getPaymentsFromId(token, id)
    }

    override fun pay(token: String, paymentRequest: PaymentRequest): Observable<PaymentResult> {
        return apiRequest.pay(token, paymentRequest)
    }
}