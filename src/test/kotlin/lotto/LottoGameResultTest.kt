package lotto

import lotto.LottoTicketTest.TicketAmount
import lotto.RankingTest.Ranking.Rank
import lotto.RankingTest.Ranking.Rank.FIRST
import lotto.RankingTest.Ranking.Rank.FOURTH
import lotto.RankingTest.Ranking.Rank.MISS
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.Test
import kotlin.math.truncate

class LottoGameResultTest {
    @Test
    fun `등급별 일치수를 센다`() {
        assertThat(LottoGameResult(listOf(FIRST, FIRST, MISS)).entries)
            .containsExactly(
                entry(FIRST, 2),
                entry(MISS, 1)
            )
    }

    @Test
    fun `등급별 당첨액 x 일치수갯수의 총합을 구한다`() {
        assertThat(LottoGameResult(listOf(FIRST, FIRST, MISS)).income)
            .isEqualTo(4_000_000_000)
    }

    @Test
    fun `구입금액 대비 당첨금액으로 수익률을 구한다`() {
        assertThat(LottoGameResult(MISS * 13 + FOURTH).profit)
            .isEqualTo(0.35)
    }

    class LottoGameResult(ranks: List<Rank>) {
        val entries: Map<Rank, Int> = ranks.groupingBy { it }.eachCount()
        val income: Long = entries.map { (rank, count) -> rank.prize(count) }.sum()
        val profit: Double = (income / TicketAmount(entries.values.sum()) * 100).truncate

        private operator fun Long.div(ticketAmount: TicketAmount): Double = this / ticketAmount.amount.toDouble()
        private val Double.truncate: Double
            get() = truncate(this) / 100
    }
}

private operator fun Rank.times(other: Int): List<Rank> = (0 until other).map { this }
