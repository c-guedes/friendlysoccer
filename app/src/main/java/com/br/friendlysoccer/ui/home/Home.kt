package com.br.friendlysoccer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.br.friendlysoccer.R
import com.br.friendlysoccer.data.repository.FirebaseRepository
import com.br.friendlysoccer.databinding.FragmentHomeBinding
import com.br.friendlysoccer.ui.login.LoginDirections
import com.google.firebase.auth.FirebaseAuth

class Home : Fragment() {
    private val mAuth = FirebaseAuth.getInstance()
    private lateinit var viewModel: HomeViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.

        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false
        )


        val repo = FirebaseRepository(mAuth)
        val viewModelFactory = HomeViewModelFactory(repo, this.activity!!.application)

        // Get a reference to the ViewModel associated with this fragment.
        viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(HomeViewModel::class.java)


        binding.homeViewModel = viewModel
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
                    }
                }
            })
    }

}