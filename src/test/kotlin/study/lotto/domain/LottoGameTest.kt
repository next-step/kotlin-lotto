package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameTest {
    private val lottoGame = LottoGame()

    @Test
    fun `earningsRate 계산이 올바르게 수행된다`() {
        val lottos = Lottos(
            listOf(
                Lotto.generate(listOf(1, 2, 3, 10, 20, 30)),
                Lotto.generate(listOf(1, 2, 3, 4, 20, 30)),
                Lotto.generate(listOf(40, 41, 42, 43, 44, 45))
            )
        )
        val winningLotto = Lotto.generate(listOf(1, 2, 3, 4, 5, 6))
        val purchaseAmount = 3000

        val result = lottoGame.calculateResult(lottos, winningLotto)
        val expectedEarningsRate = (5000 + 50000).toDouble() / purchaseAmount

        assertEquals(expectedEarningsRate, result.earningsRate, 0.001)
    }

    @Test
    fun `statistics 계산이 올바르게 수행된다`() {
        val lottos = Lottos(
            listOf(
                Lotto.generate(listOf(1, 2, 3, 10, 20, 30)),
                Lotto.generate(listOf(1, 2, 3, 4, 20, 30)),
                Lotto.generate(listOf(40, 41, 42, 43, 44, 45))
            )
        )
        val winningLotto = Lotto.generate(listOf(1, 2, 3, 4, 5, 6))

        val result = lottoGame.calculateResult(lottos, winningLotto)
        val expectedStatistics = mapOf(
            3 to 1,
            4 to 1,
            5 to 0,
            6 to 0
        )

        assertEquals(expectedStatistics, result.statistics)
    }
}
