package lotto.model

import lotto.model.LottoPrize.FIRST
import lotto.model.LottoPrize.NONE
import lotto.model.LottoPrize.SECOND
import lotto.model.LottoPrize.THIRD
import lotto.model.WinningNumbers.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    internal fun `당첨번호 갯수에 맞는 결과를 가져온다`() {
        // given
        val first = Lotto.of(1, 2, 3, 4, 5, 6)
        val second = Lotto.of(1, 2, 3, 4, 5, 46)
        val third = Lotto.of(1, 2, 3, 4, 5, 9)
        val none = Lotto.of(7, 8, 9, 10, 11, 12)
        val lottos = Lottos(listOf(first, second, third, third, none, none))
        val winningNumbers = of(Lotto.of(1, 2, 3, 4, 5, 6), 46)

        // when
        val lottoPrizes = lottos.matchWith(winningNumbers)

        // then
        assertThat(lottoPrizes.getCountOf(FIRST)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(SECOND)).isEqualTo(1)
        assertThat(lottoPrizes.getCountOf(THIRD)).isEqualTo(2)
        assertThat(lottoPrizes.getCountOf(NONE)).isEqualTo(2)
        assertThat(lottoPrizes.getTotalWinningAmount()).isEqualTo(Money.of(2_033_000_000))
    }
}
