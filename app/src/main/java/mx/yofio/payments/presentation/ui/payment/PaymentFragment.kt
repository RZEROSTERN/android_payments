package mx.yofio.payments.presentation.ui.payment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import mx.yofio.core.domain.CreditCard
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.payments.R
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.android.ext.android.inject

class PaymentFragment : Fragment() {

    private lateinit var viewModel: PaymentViewModel
    private val dependencies: ApiDependencies by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.payment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PaymentViewModel::class.java)
        viewModel.dependencies = this.dependencies
        viewModel.paymentResult.observe(viewLifecycleOwner, Observer {

        })

        viewModel.pay(arguments?.getString("token")!!,
            PaymentRequest(arguments?.getString("id")!!, 100f,
                CreditCard("4141414141414141", "1223",
                    "MARCO ANTONIO RAMIREZ SOLIS", "123")))
    }

}