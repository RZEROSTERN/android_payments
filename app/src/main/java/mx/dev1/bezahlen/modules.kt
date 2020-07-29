package mx.dev1.bezahlen

import mx.bezahlen.core.data.repositories.AuthRepositoryImp
import mx.bezahlen.core.data.repositories.PaymentsRepositoryImp
import mx.bezahlen.core.interactors.AuthInteractor
import mx.bezahlen.core.interactors.AuthInteractorImp
import mx.bezahlen.core.interactors.PaymentsInteractor
import mx.bezahlen.core.interactors.PaymentsInteractorImp
import mx.bezahlen.bezahlen.presentation.ApiDependencies
import org.koin.dsl.module

val appModule = module(override = true) {
    single<AuthInteractor> { AuthInteractorImp(AuthRepositoryImp())}
    single<PaymentsInteractor> { PaymentsInteractorImp(PaymentsRepositoryImp())}

    factory { ApiDependencies(get(), get()) }
}