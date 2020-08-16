package lotto

import lotto.domain.LottoGame
import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `수익률`() {
        val inputMoney = 10000
        val results = listOf(Rank.FOURTH)
        val expectedRatio = Rank.FOURTH.prizeMoney.toDouble() / inputMoney
        val result: Double = LottoGame.calculate(inputMoney, results)
        assertThat(result).isEqualTo(expectedRatio)
    }
}
