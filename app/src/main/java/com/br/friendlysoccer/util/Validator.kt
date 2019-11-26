package com.br.friendlysoccer.util

object Validator {
    const val PASSWORD_REGEX: String =
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}"
    const val EMAIL_REGEX: String =
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    const val NICKNAME_PATTERN: String = "^.{4,}\$"

    fun doValidate(toValidate: String, param: String): Boolean {
        return toValidate.matches(param.toRegex())
    }

}