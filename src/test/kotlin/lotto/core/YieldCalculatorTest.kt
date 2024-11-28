package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class YieldCalculatorTest {
    @Test
    fun `수익률 계산을 검증한다`() {
        YieldCalculator.calculate(mapOf(WinningRank.RANK4 to 2, WinningRank.RANK3 to 1), 5) shouldBe 12
    }
}
