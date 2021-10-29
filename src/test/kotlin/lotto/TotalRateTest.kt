package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TotalRateTest {
    @Test
    fun `총 수익률을 구한다`() {
        // given
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)

        val lottoResults = LottoResults(
            purchasedLottos = listOf(
                Lotto(listOf(8, 21, 23, 41, 42, 43)),
                Lotto(listOf(3, 5, 11, 16, 32, 38)),
                Lotto(listOf(7, 11, 16, 35, 36, 447)),
                Lotto(listOf(1, 8, 11, 31, 41, 42)),
                Lotto(listOf(13, 14, 16, 38, 42, 45)),
                Lotto(listOf(7, 11, 30, 40, 42, 43)),
                Lotto(listOf(2, 13, 22, 32, 38, 45)),
                Lotto(listOf(23, 25, 33, 36, 39, 41)),
                Lotto(listOf(1, 3, 5, 14, 22, 45)),
                Lotto(listOf(5, 9, 38, 41, 43, 44)),
                Lotto(listOf(2, 8, 9, 18, 19, 21)),
                Lotto(listOf(13, 14, 18, 21, 23, 35)),
                Lotto(listOf(17, 21, 29, 37, 42, 45)),
                Lotto(listOf(3, 8, 27, 30, 35, 44))
            )
        ).result(winningNumber)

        // when
        val totalRate = TotalRate.calculatingOf(lottoResults)

        // then
        assertThat(totalRate).isEqualTo((0.35).toBigDecimal())
    }
}
