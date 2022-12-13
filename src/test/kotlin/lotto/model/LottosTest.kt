package lotto.model

import lotto.model.LottoPrize.FIRST
import lotto.model.LottoPrize.FOURTH
import lotto.model.LottoPrize.NONE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    internal fun `당첨번호 갯수에 맞는 상(Prize)들을 가져온다`() {
        val winningNumbers = WinningNumbers(Lotto.of(1, 2, 3, 4, 5, 6))
        val first = Lotto.of(1, 2, 3, 4, 5, 6)
        val fourth = Lotto.of(1, 2, 3, 7, 8, 9)
        val none = Lotto.of(7, 8, 9, 10, 11, 12)
        val lottos = Lottos(listOf(first, fourth, none))
        val prizes = lottos.prizesFor(winningNumbers)

        assertThat(prizes).containsExactly(FIRST, FOURTH, NONE)
    }
}
