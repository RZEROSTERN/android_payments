package mx.yofio.payments.presentation.ui.payment

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.core.domain.results.PaymentResult
import mx.yofio.payments.presentation.ApiDependencies

class PaymentViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var dependencies: ApiDependencies
    var paymentResult: MutableLiveData<PaymentResult> = MutableLiveData()

    fun pay(token: String, paymentRequest: PaymentRequest) {
        compositeDisposable.add(dependencies.pay(token, paymentRequest)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> paymentResult.postValue(res)},
                {t: Throwable -> Log.e(ContentValues.TAG, t.message!!) }
            ))
    }
}