package com.br.friendlysoccer.ui.splash

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.br.friendlysoccer.R
import com.br.friendlysoccer.databinding.FragmentSplashScreenBinding

class SplashScreen : Fragment() {
    private var SPLASH_SCREEN_DELAY_MILLIS = 3000L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.

        val binding: FragmentSplashScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_splash_screen, container, false
        )

        val viewModelFactory = SplashScreenViewModelFactory(this.activity!!.application)

        // Get a reference to the ViewModel associated with this fragment.
        val splashScreenModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SplashScreenViewModel::class.java)

        binding.splashScreenViewModel = splashScreenModel
        binding.lifecycleOwner = this

        val animAccelerateDecelerate = AnimationUtils.loadAnimation(context, R.anim.fade_out);
        val image = binding.slpashText

        val animAccelerateDecelerate2 = AnimationUtils.loadAnimation(context, R.anim.move_45);
        val image2 = binding.ballSplash


        image.startAnimation(animAccelerateDecelerate)
        image2.startAnimation(animAccelerateDecelerate2)

        Handler().postDelayed(Runnable {
            findNavController().navigate(
                SplashScreenDirections.actionSlpashScreenToLoginPage()
            )
        }, SPLASH_SCREEN_DELAY_MILLIS)


        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.navigationCommand.observe(this,
//            Observer { request ->
//                request?.let {
//                    when (request){
//                        "Teste" -> findNavController().navigate(LoginDirections.actionLoginPageToCadastro())
//                    }
//                }
//            })
//    }

}
