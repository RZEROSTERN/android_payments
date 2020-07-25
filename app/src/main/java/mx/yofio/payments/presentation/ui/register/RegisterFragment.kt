package mx.yofio.payments.presentation.ui.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import mx.yofio.core.domain.requests.UserRegisterRequest
import mx.yofio.payments.R
import mx.yofio.payments.presentation.ApiDependencies
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment() {
    private lateinit var viewModel: RegisterViewModel
    private val dependencies: ApiDependencies by inject()
    private lateinit var btnRegister: Button
    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var etEmail: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.register_fragment, container, false)

        btnRegister = view.findViewById(R.id.btn_register_submit)
        etName = view.findViewById(R.id.et_register_name)
        etPhone = view.findViewById(R.id.et_register_phone)
        etPassword = view.findViewById(R.id.et_register_password)
        etEmail = view.findViewById(R.id.et_register_email)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewModel.dependencies = this.dependencies

        viewModel.registerResult.observe(viewLifecycleOwner, Observer {
            Navigation.findNavController(requireView()).navigate(R.id.action_registerFragment_to_loginFragment)
        })

        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it!!, Toast.LENGTH_LONG).show()
        })

        btnRegister.setOnClickListener {
            val registerRequest = UserRegisterRequest(etName.text.toString(), etPhone.text.toString(),
                etEmail.text.toString(), etPassword.text.toString())

            viewModel.register(registerRequest)
        }
    }
}