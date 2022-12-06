package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    internal fun `당첨번호와 맞는 숫자의 갯수를 가져온다`() {
        val lotto1 = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto.of(listOf(1, 2, 3, 7, 8, 9))
        val lotto3 = Lotto.of(listOf(7, 8, 9, 10, 11, 12))
        val lottos = Lottos(listOf(lotto1, lotto2, lotto3))
        val winningNumbers = WinningNumbers.of(listOf(1, 2, 3, 4, 5, 6))
        val matchCounts = lottos.matchCounts(winningNumbers)
        assertThat(matchCounts).containsExactly(6, 3, 0)
    }
}
