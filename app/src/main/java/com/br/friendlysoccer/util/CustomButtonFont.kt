package com.br.friendlysoccer.util

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.br.friendlysoccer.R

class CustomButtonFont : androidx.appcompat.widget.AppCompatButton {

    private var customFont: String? = null

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        if (!isInEditMode) {
            style(context, attrs)
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        if (!isInEditMode) {
            style(context, attrs)
        }

    }

    private fun style(context: Context, attrs: AttributeSet) {

        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.CustomButtonFont
        )
        val cf = a.getInteger(R.styleable.NossaFonte_fontName, 0)
        val fontName: Int
        fontName = when (cf) {
            1 -> R.string.GothamBold
            2 -> R.string.GothamBookItalic
            3 -> R.string.GothamBookLight
            5 -> R.string.GothamMedium
            else -> R.string.GothamBook
        }

        customFont = resources.getString(fontName)

        val tf = Typeface.createFromAsset(
            context.assets,
            "fonts/$customFont.ttf"
        )
        typeface = tf
        a.recycle()
    }
}