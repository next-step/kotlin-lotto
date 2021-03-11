package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class ProfitCalculation {

    fun getProfitRate(lottoGame: LottoGame, budget: Int): Float {
        val fourthSum = lottoGame.getRankCount(LottoRank.FOURTH) * LottoRank.FOURTH.winningPrice
        val thirdSum = lottoGame.getRankCount(LottoRank.THIRD) * LottoRank.THIRD.winningPrice
        val secondSum = lottoGame.getRankCount(LottoRank.SECOND) * LottoRank.SECOND.winningPrice
        val firstSum = lottoGame.getRankCount(LottoRank.FIRST) * LottoRank.FIRST.winningPrice
        val rate = (fourthSum + thirdSum + secondSum + firstSum) / budget.toFloat()
        return roundDecimal(rate)
    }

    private fun roundDecimal(number: Float): Float {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.roundingMode = RoundingMode.DOWN
        return decimalFormat.format(number).toFloat()
    }
}
