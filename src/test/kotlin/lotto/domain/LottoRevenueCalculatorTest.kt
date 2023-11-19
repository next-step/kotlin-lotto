package lotto.domain

import lotto.dto.LottoMatchResult
import lotto.enum.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoRevenueCalculatorTest {

    @Test
    @DisplayName("주어진 매치 결과로 수익률이 올바르게 계산된다")
    fun `주어진 매치 결과로 수익률이 올바르게 계산된다`() {
        val matchResult = LottoMatchResult(mapOf(5 to 1, 4 to 2), 0)
        val rankDeterminer = LottoRankDeterminer()
        val calculator = LottoRevenueCalculator(matchResult, rankDeterminer)

        val returnRate = calculator.calculateReturnRate(10000.0)
        val expectedReturn = (Rank.THIRD.winningMoney + 2 * Rank.FOURTH.winningMoney) / 10000.0

        assertEquals(expectedReturn, returnRate, 0.001)
    }
}
