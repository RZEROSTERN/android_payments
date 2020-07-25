package mx.yofio.core.interactors

import io.reactivex.Observable
import mx.yofio.core.data.repositories.PaymentsRepositoryImp
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.core.domain.results.MembershipPaymentsResult
import mx.yofio.core.domain.results.PaymentResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PaymentsInteractorImp(private val paymentsRepositoryImp: PaymentsRepositoryImp): PaymentsInteractor {
    private val logger: Logger = LoggerFactory.getLogger(AuthInteractorImp::class.java.simpleName)

    override fun getPaymentsById(token: String, id: String): Observable<MutableList<MembershipPaymentsResult>> {
        return paymentsRepositoryImp.getPaymentsFromId(token, id)
            .doOnNext { response -> logger.debug(response.toString()) }
            .doOnComplete { logger.debug("Service complete") }
            .onErrorReturn { error ->
                logger.error(error.message)
                null
            }
    }

    override fun pay(token: String, paymentRequest: PaymentRequest): Observable<PaymentResult> {
        return paymentsRepositoryImp.pay(token, paymentRequest)
            .doOnNext { response -> logger.debug(response.toString()) }
            .doOnComplete { logger.debug("Service complete") }
            .onErrorReturn { error ->
                logger.error(error.message)
                null
            }
    }
}