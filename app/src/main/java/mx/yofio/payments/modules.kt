package mx.yofio.payments

import mx.yofio.core.data.repositories.AuthRepositoryImp
import mx.yofio.core.data.repositories.PaymentsRepositoryImp
import mx.yofio.core.interactors.AuthInteractor
import mx.yofio.core.interactors.AuthInteractorImp
import mx.yofio.core.interactors.PaymentsInteractor
import mx.yofio.core.interactors.PaymentsInteractorImp
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.dsl.module

val appModule = module(override = true) {
    single<AuthInteractor> { AuthInteractorImp(AuthRepositoryImp())}
    single<PaymentsInteractor> { PaymentsInteractorImp(PaymentsRepositoryImp())}

    factory { ApiDependencies(get(), get()) }
}