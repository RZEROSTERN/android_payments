package mx.bezahlen.bezahlen.presentation.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import mx.bezahlen.core.domain.requests.UserRegisterRequest
import mx.bezahlen.core.domain.results.RegisterResult
import mx.bezahlen.bezahlen.presentation.ApiDependencies

class RegisterViewModel : ViewModel() {
    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    lateinit var dependencies: ApiDependencies
    var registerResult: MutableLiveData<RegisterResult> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun register(registerRequest: UserRegisterRequest) {
        compositeDisposable.add(dependencies.register(registerRequest)!!
            .subscribeOn(Schedulers.io())
            .subscribe(
                {res -> registerResult.postValue(res)},
                {t: Throwable -> error.postValue(t.message!!) }
            ))
    }
}