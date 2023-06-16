package lotto.domain

import java.text.DecimalFormat

class LottoStatistic(
    winningNumbers: WinningNumbers,
    lottos: Lottos,
) {
    val result: LottosResult
    val returnOfRate: Double

    init {
        result = lottos.calculateResult(winningNumbers)
        returnOfRate = (
            (
                (result.numberOfFirst * LottoPrize.FIRST.reward) +
                    (result.numberOfThird * LottoPrize.THIRD.reward) +
                    (result.numberOfFourth * LottoPrize.FOURTH.reward) +
                    (result.numberOfFifth * LottoPrize.FIFTH.reward)
                ) / lottos.cost.toDouble()
            ).round(2)
    }

    private fun Double.round(decimals: Int = 2): Double = DecimalFormat("#.${"#".repeat(decimals)}")
        .also { df -> df.roundingMode = java.math.RoundingMode.DOWN }
        .format(this).toDouble()
}
