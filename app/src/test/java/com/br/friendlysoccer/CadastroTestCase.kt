package com.br.friendlysoccer

import android.app.Application
import android.util.Log
import com.br.friendlysoccer.data.model.User
import com.br.friendlysoccer.data.repository.FirebaseRepository
import com.br.friendlysoccer.ui.cadastro.CadastroViewModel
import com.br.friendlysoccer.util.Validator
import com.br.friendlysoccer.util.Validator.EMAIL_REGEX
import com.br.friendlysoccer.util.Validator.NICKNAME_PATTERN
import com.br.friendlysoccer.util.Validator.PASSWORD_REGEX
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CadastroTestCase {
    @Test
    // fazer sempre o primeiro teste falhar pra depois inserir os outros
    fun validar_senha() {
        val senha = "Teste@123"
        assertTrue(Validator.doValidate(senha, PASSWORD_REGEX))
    }

    @Test
    fun validar_nickname() {
        val nick = "teste"                                                                       
        assertTrue(Validator.doValidate(nick, NICKNAME_PATTERN))
    }

    @Test
    fun validar_email() {
        val email = "caique@123.com"
        assertTrue(Validator.doValidate(email, EMAIL_REGEX))
    }
}
