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
        val matchCounts = mapOf(
            3 to 1,
            4 to 0,
            5 to 0,
            6 to 0
        )
        val bonusMatchCount = 0
        val matchResult = LottoMatchResult(matchCounts, bonusMatchCount)
        val calculator = LottoRevenueCalculator(matchResult)
        val purchaseAmount = 1000.0

        val expectedRevenue = Rank.FIFTH.winningMoney * matchCounts[3]!!
        val expectedReturnRate = expectedRevenue / purchaseAmount

        val actualReturnRate = calculator.calculateReturnRate(purchaseAmount)

        assertEquals(expectedReturnRate, actualReturnRate)
    }
}
