package mx.yofio.payments.presentation.ui.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.payments.R
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {
    private lateinit var viewModel: RegisterViewModel
    private val dependencies: ApiDependencies by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewModel.dependencies = this.dependencies

        val registerRequest = UserRegisterRequest("Test", "+525583177950",
            "marco.ramirez.cto@gmail.com", "Tests123")

        viewModel.registerResult.observe(viewLifecycleOwner, Observer {
            Log.d("LoginFragment", it.status)
        })

        viewModel.register(registerRequest)
    }
}