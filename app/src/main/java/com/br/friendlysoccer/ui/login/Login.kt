package com.br.friendlysoccer.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.br.friendlysoccer.R
import com.br.friendlysoccer.data.repository.FirebaseRepository
import com.br.friendlysoccer.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : Fragment() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )


        val repo = FirebaseRepository.getInstance()
        val viewModelFactory = LoginViewModelFactory(repo, this.activity!!.application)

        // Get a reference to the ViewModel associated with this fragment.
        viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(LoginViewModel::class.java)


        binding.loginViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val application = requireNotNull(this.activity).application

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigationCommand.observe(this,
            Observer { request ->
                request?.let {
                    when (request) {
                        "Teste" -> findNavController().navigate(LoginDirections.actionLoginPageToCadastro())
                        "Teste2" -> findNavController().navigate(LoginDirections.actionLoginPageToHome())
                    }
                }
            })
    }



    fun toCadastro() {
        this.findNavController().navigate(
            LoginDirections.actionLoginPageToCadastro()
        )


    }

}