package mx.bezahlen.bezahlen.presentation.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.bezahlen.core.domain.requests.LoginRequest
import mx.bezahlen.core.domain.results.LoginResult
import mx.bezahlen.bezahlen.presentation.ApiDependencies

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