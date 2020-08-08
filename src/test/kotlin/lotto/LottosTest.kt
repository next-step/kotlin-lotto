package lotto

import lotto.Lotto.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    internal fun match() {
        val lottos = Lottos(listOf(
            of(1, 2, 3, 4, 5, 6),
            of(1, 2, 3, 4, 5, 7),
            of(1, 2, 3, 4, 5, 8),
            of(8, 2, 3, 4, 5, 6),
            of(1, 2, 3, 4, 8, 9),
            of(1, 2, 3, 8, 9, 10),
            of(1, 2, 8, 9, 10, 11)
        ))

        val winningLotto = WinningLotto("1, 2, 3, 4, 5, 6", 7)
        val lottoResult = lottos.match(winningLotto)

        assertThat(lottoResult.countByRank(Rank.FIRST)).isEqualTo(1)
        assertThat(lottoResult.countByRank(Rank.SECOND)).isEqualTo(1)
        assertThat(lottoResult.countByRank(Rank.THIRD)).isEqualTo(2)
        assertThat(lottoResult.countByRank(Rank.FORTH)).isEqualTo(1)
        assertThat(lottoResult.countByRank(Rank.FIFTH)).isEqualTo(1)
    }
}
