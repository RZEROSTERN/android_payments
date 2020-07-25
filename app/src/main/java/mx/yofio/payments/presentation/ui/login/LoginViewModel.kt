package mx.yofio.payments.presentation.ui.login

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.yofio.core.domain.requests.LoginRequest
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.LoginResult
import mx.yofio.core.domain.results.RegisterResult
import mx.yofio.payments.presentation.ApiDependencies

class LoginViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var dependencies: ApiDependencies
    var loginResult: MutableLiveData<LoginResult> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()


    fun login(loginRequest: LoginRequest) {
        compositeDisposable.add(dependencies.login(loginRequest)!!
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> loginResult.postValue(res)},
                {t: Throwable -> error.postValue(t.message!!) }
            ))
    }
}