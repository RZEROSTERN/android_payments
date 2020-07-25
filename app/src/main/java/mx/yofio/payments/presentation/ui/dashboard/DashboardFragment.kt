package mx.yofio.payments.presentation.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mx.yofio.core.domain.results.MembershipPaymentsResult
import mx.yofio.payments.R
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.android.ext.android.inject

class DashboardFragment : Fragment() {
    private lateinit var viewModel: DashboardViewModel
    private val dependencies: ApiDependencies by inject()
    private lateinit var items: MutableList<MembershipPaymentsResult>
    private lateinit var fabNewPayment: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboard_fragment, container, false)
        fabNewPayment = view.findViewById(R.id.fab_new_payment)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        viewModel.dependencies = this.dependencies

        viewModel.membershipPaymentsResult.observe(viewLifecycleOwner, Observer {
            items = it
        })

        viewModel.getPaymentsById("Bearer " + arguments?.getString("token")!!, arguments?.getString("id")!!)

        fabNewPayment.setOnClickListener {
            val bundle = bundleOf("token" to arguments?.getString("token")!!, "id" to arguments?.getString("id")!!)
            Navigation.findNavController(requireView()).navigate(R.id.action_dashboardFragment_to_paymentFragment, bundle)
        }
    }

}