package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoProfitCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        "14_000, 5_000, 0.35, 손해",
        "14_999, 5_000, 0.33, 손해",
        "1_000, 2_000_000_000, 2_000_000.00, 이익",
        "5_000, 5_000, 1.00, 본전"
    )
    fun `주어진 로또 구매액과 수익 금액에 따라 수익을 계산한다`(
        purchaseAmount: Int,
        winningMoney: Int,
        expectedRateOfReturn: Double,
        expectedProfitMsg: String
    ) {
        // given
        // when
        val profit = LottoProfitCalculator.calcProfit(purchaseAmount, winningMoney)
        // then
        assertEquals(expectedRateOfReturn, profit.rateOfReturn)
        assertEquals(expectedProfitMsg, profit.resultMsg)
    }
}
