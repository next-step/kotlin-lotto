package lotto

import lotto.RankingTest.Ranking.Rank.FIRST
import lotto.RankingTest.Ranking.Rank.MISS
import lotto.RankingTest.Ranking.Rank.SECOND
import org.junit.jupiter.api.Test

class LottoGameResultTest {
    @Test
    fun `등급별 일치수를 센다`() {
        assertThat(LottoGameResult(listOf(FIRST, SECOND, MISS)))
            .containsExactly(
                entry(FIRST, 2),
                entry(MISS, 1)
            )
    }
}
