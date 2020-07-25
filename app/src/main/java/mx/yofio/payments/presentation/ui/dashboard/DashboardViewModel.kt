package mx.yofio.payments.presentation.ui.dashboard

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.yofio.core.domain.results.MembershipPaymentsResult
import mx.yofio.payments.presentation.ApiDependencies

class DashboardViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var dependencies: ApiDependencies
    var membershipPaymentsResult: MutableLiveData<MutableList<MembershipPaymentsResult>> = MutableLiveData()

    fun getPaymentsById(token: String, id: String) {
        compositeDisposable.add(dependencies.getPaymentsById(token, id)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> membershipPaymentsResult.postValue(res)},
                {t: Throwable -> Log.e(ContentValues.TAG, t.message!!) }
            ))
    }
}