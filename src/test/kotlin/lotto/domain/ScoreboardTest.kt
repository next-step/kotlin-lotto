package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScoreboardTest {
    @Test
    fun `총 상금의 합을 계산한다`() {
        // given
        val ticket1 = Lotto.of(1, 2, 3, 4, 5, 6)
        val ticket2 = Lotto.of(1, 2, 3, 4, 5, 7)
        val lottos = Lottos(listOf(ticket1, ticket2))

        // when
        val winningLotto = Lotto.of(1, 2, 3, 4, 5, 6)
        val scoreboard = Scoreboard.of(lottos, winningLotto)

        // then
        assertThat(scoreboard.totalPrize()).isEqualTo(
            Prize.MATCH_SIX.money + Prize.MATCH_FIVE.money
        )
    }
}

