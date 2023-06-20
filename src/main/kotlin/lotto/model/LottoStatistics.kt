package lotto.model

import java.math.RoundingMode
import java.text.DecimalFormat

object LottoStatistics {
    fun totalStatistics(result: Map<LottoPrize, Int>, amount: Int): Double = result.toList().sumOf {
        it.first.prize * it.second
    }.toDouble() / amount
}

fun Double.toDecimalPoint(): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    return df.format(this)
}
