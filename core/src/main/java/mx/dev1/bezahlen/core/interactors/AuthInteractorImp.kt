package mx.dev1.bezahlen.core.interactors

import io.reactivex.Observable
import mx.dev1.bezahlen.core.data.repositories.AuthRepositoryImp
import mx.dev1.bezahlen.core.domain.requests.LoginRequest
import mx.dev1.bezahlen.core.domain.requests.UserRegisterRequest
import mx.dev1.bezahlen.core.domain.results.LoginResult
import mx.dev1.bezahlen.core.domain.results.RegisterResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AuthInteractorImp(private val userRepositoryImp: AuthRepositoryImp): AuthInteractor {
    private val logger: Logger = LoggerFactory.getLogger(AuthInteractorImp::class.java.simpleName)

    override fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult>? {
        if(!validateRegister(registerRequest)) {
            return Observable.error(Throwable("Invalid data. Please check your name, phone number and password."))
        }

        return userRepositoryImp.register(registerRequest)
            .doOnNext { response -> run {
                logger.debug(response.toString())
            }}
            .doOnComplete { logger.debug("Service complete") }
            .onErrorReturn { error ->
                logger.error(error.message)
                RegisterResult(-1, error.message!!, null, null,
                    null, null, null)
            }
    }

    override fun login(loginRequest: LoginRequest): Observable<LoginResult>? {
        if(!validateLogin(loginRequest)) {
            return Observable.error(Throwable("Invalid data. Please check your phone number and password."))
        }

        return userRepositoryImp.login(loginRequest)
            .doOnNext { response -> logger.debug(response.toString()) }
            .doOnComplete { logger.debug("Service complete") }
            .onErrorReturn { error ->
                logger.error(error.message)
                null
            }
    }

    private fun validateRegister(registerRequest: UserRegisterRequest): Boolean {
        if(registerRequest.full_name.split(" ").size > 1) {
            for(item: String in registerRequest.full_name.split(" ")) {
                if(!item.matches(Regex("\\b[A-Z].*?\\b"))){
                    return false
                }
            }
        }

        if(!registerRequest.phone_number.matches(Regex("(\\+52)([0-9]{10})")) ||
            !registerRequest.password.matches(Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))){
            return false
        }

        return true
    }

    private fun validateLogin(loginRequest: LoginRequest): Boolean {
        if(!loginRequest.phone_number.matches(Regex("(\\+52)([0-9]{10})")) ||
                !loginRequest.password.matches(Regex("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$"))){
            return false
        }

        return true
    }
}