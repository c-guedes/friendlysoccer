package com.br.friendlysoccer.ui

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import com.br.friendlysoccer.R

class teste(context: Context?): Dialog(context!!) {

    init {
        this.setContentView(R.layout.kkkk)
    }

    fun clear(){
        this.cancel()
    }
}