package com.br.friendlysoccer.ui.common

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

/**
 * An Email format validator for [android.widget.EditText].
 */
class EmailValidator : TextWatcher {
    var isValid = false
        private set

    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidEmail(editableText)
    }

    override fun beforeTextChanged(
        s: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ) { /*No-op*/
    }

    override fun onTextChanged(
        s: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) { /*No-op*/
    }

    companion object {
        /**
         * Email validation pattern.
         */
        val EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        /**
         * Validates if the given input is a valid email address.
         *
         * @param email        The email to validate.
         * @return `true` if the input is a valid email. `false` otherwise.
         */
        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && EMAIL_PATTERN.matcher(email).matches()
        }
    }
}