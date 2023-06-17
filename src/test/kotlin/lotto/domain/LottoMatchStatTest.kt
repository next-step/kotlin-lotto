package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LottoMatchStatTest {
    @Test
    internal fun `로또 당첨 통계와 구입 금액을 통해 로또의 수익률을 구할 수 있어야한다`() {
        val sut = LottoMatchStat(
            threeMatchCount = 1,
            fourMatchCount = 0,
            fiveMatchCount = 0,
            sixMatchCount = 0
        )
        val actualEarningsRate = sut.calculateEarningsRate(10000)
        actualEarningsRate shouldBe 0.5
    }
}
