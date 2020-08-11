package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoTicketTest {
    @Test
    fun match() {
        val lottos = LottoTicket(
            listOf(
                Lotto(1, 2, 3, 4, 5, 6),
                Lotto(1, 2, 3, 4, 5, 7),
                Lotto(1, 2, 3, 4, 5, 8),
                Lotto(8, 2, 3, 4, 5, 6),
                Lotto(1, 2, 3, 4, 8, 9),
                Lotto(1, 2, 3, 8, 9, 10),
                Lotto(1, 2, 8, 9, 10, 11)
            )
        )

        val winningLotto = WinningLotto(Lotto(1, 2, 3, 4, 5, 6), LottoNumber(7))
        val lottoResult = lottos.match(winningLotto)

        assertThat(lottoResult.countByRank(Rank.FIRST)).isEqualTo(1)
        assertThat(lottoResult.countByRank(Rank.SECOND)).isEqualTo(1)
        assertThat(lottoResult.countByRank(Rank.THIRD)).isEqualTo(2)
        assertThat(lottoResult.countByRank(Rank.FOURTH)).isEqualTo(1)
        assertThat(lottoResult.countByRank(Rank.FIFTH)).isEqualTo(1)
    }
}
