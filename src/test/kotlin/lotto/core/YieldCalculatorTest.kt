package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class YieldCalculatorTest {
    @Test
    fun `수익률 계산을 검증한다`() {
        val lottos = Lottos(listOf(Lotto((4..10).toList()), Lotto((3..9).toList())))

        lottos.forEach {
            it.checkWinningStates(WinningNumbers((1..6).toList()))
        }

        YieldCalculator.calculate(lottos) shouldBe 27.5
    }
}
