package mx.yofio.payments.presentation.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import mx.yofio.core.domain.requests.LoginRequest
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.payments.R
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private val dependencies: ApiDependencies by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.login_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var loginRequest = LoginRequest("+525583177950", "Tests123")

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.dependencies = this.dependencies

        viewModel.loginResult.observe(viewLifecycleOwner, Observer {
            val bundle = bundleOf("token" to it.token, "id" to it.id)
            Navigation.findNavController(requireView()).navigate(R.id.action_loginFragment_to_dashboardFragment, bundle)
        })

        viewModel.login(loginRequest)

    }

}