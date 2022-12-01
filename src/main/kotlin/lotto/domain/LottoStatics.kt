package lotto.domain

import kotlin.math.floor

class LottoStatics(private val winners: List<Winner> = emptyList()) {

    val totalReward: Int = calculateTotalReward()

    val winningResult: WinningResult = calculateWinningCount()

    private fun calculateTotalReward(): Int {
        var total = 0
        winners.forEach { winner ->
            total += winner.prize
        }
        return total
    }

    private fun calculateWinningCount(): WinningResult {
        var result = WinningResult()
        winners.forEach { winner ->
            result = when (winner) {
                Winner.FIRST_GRADE -> result.copy(numberOfFirstGrade = result.numberOfFirstGrade + 1)
                Winner.SECOND_GRADE -> result.copy(numberOfSecondGrade = result.numberOfSecondGrade + 1)
                Winner.THIRD_GRADE -> result.copy(numberOfThirdGrade = result.numberOfThirdGrade + 1)
                Winner.FOURTH_GRADE -> result.copy(numberOfFourthGrade = result.numberOfFourthGrade + 1)
                Winner.FIVE_GRADE,
                Winner.SIX_GRADE,
                Winner.NO_MATCH -> result
            }
        }
        return result
    }

    fun calculateEarningRate(prize: Int, amount: Int): Float {
        val result: Float = prize.toFloat().div(amount.toFloat())
        return floor(result * 100).div(100f)
    }
}
