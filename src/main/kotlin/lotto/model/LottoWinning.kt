package lotto.model

import java.math.RoundingMode
import java.text.DecimalFormat

class LottoWinning(numbers: String) {

    private val winningNumbers = Lotto.createWinning(numbers)

    fun lottoResult(lottoList: List<Lotto>): Map<LottoPrize, Int> {
        val result = mutableMapOf<LottoPrize, Int>()
        lottoList.forEach {
            val count = numbersOfWinningCount(it)
            val lottoPrize = LottoPrize.of(count) ?: return@forEach
            result[lottoPrize] = result.getOrDefault(lottoPrize, 0) + 1
        }
        return result
    }
    private fun numbersOfWinningCount(lotto: Lotto): Int = winningNumbers.numbers.count {
        it in lotto.numbers
    }

    fun totalStatistics(result: Map<LottoPrize, Int>, amount: Int): Double = result.toList().sumOf {
        it.first.prize * it.second
    }.toDouble() / amount

}

fun Double.toDecimalPoint(): String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    return df.format(this)
}
