package com.br.friendlysoccer.ui.cadastro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.br.friendlysoccer.R
import com.br.friendlysoccer.data.repository.FirebaseRepository
import com.br.friendlysoccer.databinding.FragmentCadastroBinding
import com.google.firebase.auth.FirebaseAuth

class Cadastro : Fragment() {
    private val mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentCadastroBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_cadastro, container, false
        )

        val repo = FirebaseRepository(mAuth)
        val viewModelFactory = CadastrosViewModelFactory(repo, this.activity!!.application)

        // Get a reference to the ViewModel associated with this fragment.
        val cadastroViewModels =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(CadastroViewModel::class.java)


        binding.cadastroViewModel = cadastroViewModels
        binding.lifecycleOwner = this

        return binding.root
    }

}
