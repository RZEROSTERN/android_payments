package mx.yofio.core.interactors

import io.reactivex.Observable
import mx.yofio.core.data.repositories.AuthRepositoryImp
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.core.domain.results.RegisterResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class AuthInteractorImp(private val userRepositoryImp: AuthRepositoryImp): AuthInteractor {
    val logger: Logger = LoggerFactory.getLogger(AuthInteractorImp::class.java.simpleName)

    override fun register(registerRequest: UserRegisterRequest): Observable<RegisterResult> {
        return userRepositoryImp.register(registerRequest)
            .doOnNext { response -> logger.debug(response.toString()) }
            .doOnComplete { logger.debug("Service complete") }
            .onErrorReturn { error ->
                logger.error(error.message)
                null
            }
    }
}