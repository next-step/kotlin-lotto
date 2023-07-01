package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.model.Count
import lotto.domain.model.LottoResult
import lotto.domain.model.Money
import lotto.domain.model.Prize
import org.junit.jupiter.api.Test

class LottoCalculatorTest {

    @Test
    fun `수익률을 소수 두 번째 자리까지 구한다`() {
        val results = listOf(LottoResult(Count(1), Prize.THREE_MATCH))
        val money = Money(14000)

        LottoCalculator.earningRate(results, money) shouldBe 0.35
    }
}
