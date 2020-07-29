package mx.bezahlen.bezahlen.presentation.ui.payment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.bezahlen.core.domain.requests.PaymentRequest
import mx.bezahlen.core.domain.results.PaymentResult
import mx.bezahlen.bezahlen.presentation.ApiDependencies

class PaymentViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var dependencies: ApiDependencies
    var paymentResult: MutableLiveData<PaymentResult> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun pay(token: String, paymentRequest: PaymentRequest) {
        compositeDisposable.add(dependencies.pay(token, paymentRequest)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> paymentResult.postValue(res)},
                {t: Throwable -> error.postValue(t.message) }
            ))
    }
}