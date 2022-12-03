package lotto.domain

import lotto.domain.model.Rank
import lotto.domain.model.WinningResult
import kotlin.math.floor

class LottoStatics(private val ranks: List<Rank> = emptyList()) {

    val totalReward: Int = calculateTotalReward()

    val winningResult: WinningResult = calculateWinningCount()

    private fun calculateTotalReward(): Int {
        var total = 0
        ranks.forEach { winner ->
            total += winner.prize
        }
        return total
    }

    private fun calculateWinningCount(): WinningResult {
        var result = WinningResult()
        ranks.forEach { winner ->
            result = when (winner) {
                Rank.FIRST_GRADE -> result.copy(numberOfFirstGrade = result.numberOfFirstGrade + 1)
                Rank.SECOND_GRADE -> result.copy(numberOfSecondGrade = result.numberOfSecondGrade + 1)
                Rank.THIRD_GRADE -> result.copy(numberOfThirdGrade = result.numberOfThirdGrade + 1)
                Rank.FOURTH_GRADE -> result.copy(numberOfFourthGrade = result.numberOfFourthGrade + 1)
                Rank.FIFTH_GRADE -> result.copy(numberOfFifthGrade = result.numberOfFifthGrade + 1)
                Rank.NO_MATCH -> result
            }
        }
        return result
    }

    fun calculateEarningRate(prize: Int, amount: Int): Float {
        val result: Float = prize.toFloat().div(amount.toFloat())
        return floor(result * 100).div(100f)
    }
}
