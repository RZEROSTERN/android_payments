package mx.yofio.payments.presentation.ui.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import mx.yofio.core.domain.CreditCard
import mx.yofio.core.domain.requests.PaymentRequest
import mx.yofio.payments.R
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.android.ext.android.inject

class PaymentFragment : Fragment() {

    private lateinit var viewModel: PaymentViewModel
    private val dependencies: ApiDependencies by inject()
    private lateinit var btnPay: Button
    private lateinit var etName: EditText
    private lateinit var etAmount: EditText
    private lateinit var etNumber: EditText
    private lateinit var etExp: EditText
    private lateinit var etCVC: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.payment_fragment, container, false)

        btnPay = view.findViewById(R.id.btn_pay_submit)
        etName = view.findViewById(R.id.et_pay_cardholdername)
        etAmount = view.findViewById(R.id.et_pay_amount)
        etNumber = view.findViewById(R.id.et_pay_cardnumber)
        etExp = view.findViewById(R.id.et_pay_expdate)
        etCVC = view.findViewById(R.id.et_pay_cvc)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PaymentViewModel::class.java)
        viewModel.dependencies = this.dependencies

        viewModel.paymentResult.observe(viewLifecycleOwner, Observer {
            val bundle = bundleOf("token" to arguments?.getString("token")!!, "id" to arguments?.getString("id")!!)
            Toast.makeText(requireContext(), getString(R.string.thanks), Toast.LENGTH_LONG).show()
            Navigation.findNavController(requireView()).navigate(R.id.action_paymentFragment_to_dashboardFragment, bundle)
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it!!, Toast.LENGTH_LONG).show()
        })

        btnPay.setOnClickListener {
            viewModel.pay(arguments?.getString("token")!!,
                PaymentRequest(arguments?.getString("id")!!, etAmount.text.toString().toFloat(),
                    CreditCard(etNumber.text.toString(), etExp.text.toString(),
                        etName.text.toString(), etCVC.text.toString())))
        }
    }

}