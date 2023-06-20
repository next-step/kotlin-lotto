package lotto.model

import java.math.RoundingMode
import java.text.DecimalFormat

object LottoStatistics {
    fun totalStatistics(result: Map<Rank, Int>, amount: Int): Double = result.toList().sumOf {
        it.first.reward * it.second
    }.toDouble() / amount
}

fun Double.toDecimalPoint(): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    return df.format(this)
}
