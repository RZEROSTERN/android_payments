package mx.yofio.payments.presentation.ui.register

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult
import mx.yofio.payments.presentation.ApiDependencies

class RegisterViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var dependencies: ApiDependencies
    var registerResult: MutableLiveData<RegisterResult> = MutableLiveData()

    fun register(registerRequest: UserRegisterRequest) {
        compositeDisposable.add(dependencies.register(registerRequest)!!
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> registerResult.postValue(res)},
                {t: Throwable -> Log.e(ContentValues.TAG, t.message!!) }
            ))
    }
}