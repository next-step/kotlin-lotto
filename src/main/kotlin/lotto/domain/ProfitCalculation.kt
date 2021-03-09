package lotto.domain

import java.math.RoundingMode
import java.text.DecimalFormat

class ProfitCalculation {

    fun getProfitRate(lottoGame: LottoGame, budget: Int): Float {
        val fourthSum = lottoGame.getRankCount(LottoRank.FOURTH) * FOUR_WINNING_PRICE
        val thirdSum = lottoGame.getRankCount(LottoRank.THIRD) * THIRD_WINNING_PRICE
        val secondSum = lottoGame.getRankCount(LottoRank.SECOND) * SECOND_WINNING_PRICE
        val firstSum = lottoGame.getRankCount(LottoRank.FIRST) * FIRST_WINNING_PRICE
        val rate = (fourthSum + thirdSum + secondSum + firstSum) / budget.toFloat()
        return roundDecimal(rate)
    }

    private fun roundDecimal(number: Float): Float {
        val decimalFormat = DecimalFormat("#.##")
        decimalFormat.roundingMode = RoundingMode.DOWN
        return decimalFormat.format(number).toFloat()
    }

    companion object {
        private const val FIRST_WINNING_PRICE = 2000000000
        private const val SECOND_WINNING_PRICE = 1500000
        private const val THIRD_WINNING_PRICE = 50000
        private const val FOUR_WINNING_PRICE = 5000
    }
}
