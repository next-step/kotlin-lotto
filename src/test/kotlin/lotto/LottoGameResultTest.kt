package lotto

import lotto.Ranking.Rank
import lotto.Ranking.Rank.FIRST
import lotto.Ranking.Rank.MISS
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test

class LottoGameResultTest {
    @Test
    fun `등급별 일치수를 센다`() {
        assertThat(LottoGame.Result(listOf(FIRST, FIRST, MISS)).entries())
            .containsExactly(
                entry(FIRST, 2),
                entry(MISS, 1)
            )
    }

    @Test
    fun `등급별 당첨액 x 일치수갯수의 총합을 구한다`() {
        assertThat(LottoGame.Result(listOf(FIRST, FIRST, MISS)).income())
            .isEqualTo(4_000_000_000)
    }

    @Test
    fun `구입금액 대비 당첨금액으로 수익률을 구한다`() {
        assertThat(LottoGame.Result(MISS * 13 + Rank.FIFTH).profit())
            .isEqualTo(0.35)
    }

    private operator fun Rank.times(other: Int): List<Rank> = (0 until other).map { this }
}
