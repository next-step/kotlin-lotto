package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

object LottoStatics {
    private val bepFormat = DecimalFormat("#.##")
        .apply {
            roundingMode = RoundingMode.DOWN
        }

    fun makeStatics() {

    }

    fun calculateBEP(reward: Float, amount: Float): Float {
        return bepFormat.format(reward.div(amount)).toFloat()
    }
}
