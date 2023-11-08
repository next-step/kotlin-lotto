package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameResultTest {

    @Test
    fun `earningsRate 계산이 올바르게 수행된다`() {
        val lottos = Lottos(
            listOf(
                Lotto(LottoNumber.listOf(1, 2, 3, 10, 20, 30).let(::LottoNumbers)),
                Lotto(listOf(1, 2, 3, 4, 20, 30).map(::LottoNumber).let(::LottoNumbers)),
                Lotto(listOf(40, 41, 42, 43, 44, 45).map(::LottoNumber).let(::LottoNumbers))
            )
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::LottoNumbers))
        val purchaseAmount = 3000

        val result = LottoGameResult.getResult(lottos, winningLotto)
        val expectedEarningsRate = (5000 + 50000).toDouble() / purchaseAmount

        assertEquals(expectedEarningsRate, result.earningsRate, 0.001)
    }

    @Test
    fun `statistics 계산이 올바르게 수행된다`() {
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 10, 20, 30).map(::LottoNumber).let(::LottoNumbers)),
                Lotto(listOf(1, 2, 3, 4, 20, 30).map(::LottoNumber).let(::LottoNumbers)),
                Lotto(listOf(40, 41, 42, 43, 44, 45).map(::LottoNumber).let(::LottoNumbers))
            )
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).let(::LottoNumbers))

        val result = LottoGameResult.getResult(lottos, winningLotto)
        val expectedStatistics = mapOf(
            3 to 1,
            4 to 1,
            5 to 0,
            6 to 0
        )

        assertEquals(expectedStatistics, result.statistics)
    }
}
