package com.maasbodev.punkbeer.ui.detail

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.maasbodev.domain.Beer
import com.maasbodev.punkbeer.data.server.entities.MashTemp

class BeerDetailInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
    ): AppCompatTextView(context, attrs, defStyleAttr) {

        fun setBeer(beer: Beer) = with(beer) {
            text = buildSpannedString {

                bold { append("Tagline: ") }
                appendLine(tagline)

                bold { append("First brewed: ") }
                appendLine(first_brewed)

                bold { append("Description: ") }
                appendLine(description)

                bold { append("Volume: ") }
                appendLine(volume)

                bold { append("Boil volume: ") }
                appendLine(boil_volume)

                bold { append("Method: ") }
                appendLine(method.joinToString(separator = System.lineSeparator()))

                bold { append("Ingredients: ") }
                appendLine(ingredients.joinToString(separator = System.lineSeparator()))

                bold { append("Food pairing: ") }
                appendLine(food_pairing.joinToString(separator = System.lineSeparator()))

                bold { append("Brewers tips: ") }
                appendLine(brewers_tips)

                bold { append("Contributed by: ") }
                appendLine(contributed_by)

            }
        }

}

private fun Double.format(digits: Int): String = "%.${digits}".format(this)