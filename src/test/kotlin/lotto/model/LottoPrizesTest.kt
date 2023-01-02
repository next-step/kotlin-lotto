package lotto.model

import lotto.model.LottoPrize.FIFTH
import lotto.model.LottoPrize.FOURTH
import lotto.model.LottoPrize.NONE
import lotto.model.LottoPrize.SECOND
import lotto.model.LottoPrize.THIRD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizesTest {
    @Test
    fun `총 당청 금액을 계산한다`() {
        // given, when
        val lottoPrizes = LottoPrizes.of(NONE, FOURTH, FIFTH)

        // then
        assertThat(lottoPrizes.getTotalWinningAmount()).isEqualTo(Money.of(55_000))
    }

    @Test
    fun `등수 별 당첨결과를 출력한다`() {
        // given, when
        val lottoPrizes = LottoPrizes.of(NONE, THIRD, FOURTH)

        // then
        assertThat(lottoPrizes.getCountOf(NONE)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(THIRD)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(FOURTH)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(SECOND)).isEqualTo(0)
    }
}
