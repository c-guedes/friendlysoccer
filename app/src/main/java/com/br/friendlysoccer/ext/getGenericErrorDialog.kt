package com.br.friendlysoccer.ext


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

fun getGenericErrorDialog(context: Context): AlertDialog =
    AlertDialog.Builder(context)
        .setTitle("A")
        .setMessage("Generic message")
        .setPositiveButton("Aa", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
        .create()

fun DialogFragment.showIfNonExistent(manager: FragmentManager, tag: String) {
    if (manager.findFragmentByTag(tag) == null)
        this.show(manager, tag)
}

fun DialogFragment.showNowIfNonExistent(manager: FragmentManager, tag: String) {
    if (manager.findFragmentByTag(tag) == null)
        this.showNow(manager, tag)
}