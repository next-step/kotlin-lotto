package lotto.model

import lotto.model.Lotto.Companion.LOTTO_PRICE
import lotto.model.LottoPrize.FIRST
import lotto.model.LottoPrize.FOURTH
import lotto.model.LottoPrize.NONE
import lotto.model.LottoPrize.SECOND
import lotto.model.LottoPrize.THIRD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class WinningResultTest {
    @Test
    internal fun `총 당청 금액을 계산한다`() {
        // given
        val prizes = LottoPrizes.of(NONE, FOURTH, FOURTH, FOURTH, THIRD, THIRD)
        val purchaseAmount = LOTTO_PRICE * 6

        // when
        val winningResult = WinningResult(purchaseAmount, prizes)

        // then
        assertThat(winningResult.getTotalWinningAmount()).isEqualTo(Money.of(3_150_000))
    }

    @Test
    internal fun `당첨 수익률을 계산한다`() {
        // given
        val prizes = LottoPrizes.of(NONE, FOURTH, FOURTH, FOURTH, THIRD, THIRD)
        val purchaseAmount = LOTTO_PRICE * 6

        // when
        val winningResult = WinningResult(purchaseAmount, prizes)

        // then
        assertThat(winningResult.getReturnRatio()).isEqualTo(BigDecimal("525.00"))
    }

    @Test
    internal fun `등수 별 당첨결과를 출력한다`() {
        // given
        val prizes = LottoPrizes.of(NONE, FOURTH, FOURTH, FOURTH, THIRD, THIRD)
        val purchaseAmount = LOTTO_PRICE * 6

        // when
        val winningResult = WinningResult(purchaseAmount, prizes)

        // then
        assertThat(winningResult.getCountOf(NONE)).isEqualTo(1)
        assertThat(winningResult.getCountOf(FOURTH)).isEqualTo(3)
        assertThat(winningResult.getCountOf(THIRD)).isEqualTo(2)
        assertThat(winningResult.getCountOf(SECOND)).isEqualTo(0)
        assertThat(winningResult.getCountOf(FIRST)).isEqualTo(0)
    }
}
