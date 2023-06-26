package lotto.domain

import lotto.dto.PurchasedLotteryPapers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class YieldCalculatorTest {

    private lateinit var yieldCalculator: YieldCalculator

    @BeforeEach()
    fun setUp() {
        yieldCalculator = YieldCalculator()
    }

    @Test
    fun `당첨 통계를 가지고 수익률을 계산한다`() {
        val capital = 14000
        val lottoMatchResult = mapOf(
            PrizeLevel.FOURTH to 1,
            PrizeLevel.THIRD to 0,
            PrizeLevel.SECOND to 0,
            PrizeLevel.FIRST to 0
        )
        val purchasedLotteryPapers = PurchasedLotteryPapers(lottoMatchResult)

        val acutal = yieldCalculator.calulateYield(capital, purchasedLotteryPapers)
        val answer = 0.35

        Assertions.assertThat(acutal).isEqualTo(answer)
    }
}
