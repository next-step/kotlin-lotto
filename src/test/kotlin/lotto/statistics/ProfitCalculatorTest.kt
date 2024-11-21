package lotto.statistics

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {
    @Test
    fun `당첨금액과 구매급액으로 수익률을 계산한다`() {
        ProfitCalculator.evaluate(winningAmount = 5_000, purchaseAmount = 14_000) shouldBe 0.35
    }
}
