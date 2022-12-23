package lotto.model

import lotto.model.LottoPrize.FIFTH
import lotto.model.LottoPrize.FOURTH
import lotto.model.LottoPrize.NONE
import lotto.model.LottoPrize.SECOND
import lotto.model.LottoPrize.THIRD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class LottoPrizesTest {
    @Test
    fun `총 당청 금액을 계산한다`() {
        val lottoPrizes = LottoPrizes.of(NONE, FOURTH, FIFTH)
        assertThat(lottoPrizes.getTotalWinningAmount()).isEqualTo(BigDecimal(55_000))
    }

    @Test
    fun `등수 별 당첨결과를 출력한다`() {
        val lottoPrizes = LottoPrizes.of(NONE, THIRD, FOURTH)
        assertThat(lottoPrizes.getCountOf(NONE)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(THIRD)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(FOURTH)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(SECOND)).isEqualTo(0)
    }
}
