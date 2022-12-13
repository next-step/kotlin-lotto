package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class WinningResultTest {
    private val winningResult by lazy {
        val none = Lotto.of(listOf(7, 8, 9, 10, 11, 12))
        val third = Lotto.of(listOf(1, 2, 3, 4, 45, 46))
        val fourth = Lotto.of(listOf(1, 2, 3, 44, 45, 46))
        val lottos = Lottos(listOf(none, fourth, fourth, fourth, third, third))
        val winningNumbers = WinningNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        WinningResult(lottos, winningNumbers)
    }

    @Test
    internal fun `총 당청 금액을 계산한다`() {
        assertThat(winningResult.getTotalPrize()).isEqualTo(BigDecimal(115000))
    }

    @Test
    internal fun `당첨 수익률을 계산한다`() {
        assertThat(winningResult.getReturnRatio()).isEqualTo(BigDecimal("19.17"))
    }

    @Test
    internal fun `등수 별 당첨결과를 출력한다`() {
        assertThat(winningResult.getCountOf(LottoPrize.NONE)).isEqualTo(1)
        assertThat(winningResult.getCountOf(LottoPrize.FOURTH)).isEqualTo(3)
        assertThat(winningResult.getCountOf(LottoPrize.THIRD)).isEqualTo(2)
        assertThat(winningResult.getCountOf(LottoPrize.SECOND)).isEqualTo(0)
        assertThat(winningResult.getCountOf(LottoPrize.FIRST)).isEqualTo(0)
    }
}
