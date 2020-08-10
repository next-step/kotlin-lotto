package lotto

import lotto.domain.LottoGame
import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `수익률`() {
        val money = 10000
        val results = listOf(Rank.FOURTH)
        val expectedRatio = Rank.FOURTH.prizeMoney.toDouble() / money
        val result: Double = LottoGame.calculate(money, results)
        assertThat(result).isEqualTo(expectedRatio)
    }
}
