package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoCalculatorTest {

    @Test
    fun `수익률을 소수 두 번째 자리까지 구한다`() {
        val results = listOf(0, 0, 0, 1, 0, 0, 0)
        val money = 14000

        LottoCalculator.earningRate(results, money) shouldBe 0.35
    }
}
