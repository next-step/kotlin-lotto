package lotto

import lotto.LottoDrawMachineTest.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankingTest {
    @Test
    fun `두 번호그룹을 비교하여 일치수를 알 수 있다`() {
        assertThat(
            Ranking(LottoNumber(1, 2, 3, 4, 5, 6), LottoNumber(1, 2, 3, 4, 5, 6)).rank
        ).isEqualTo(Ranking.Rank.FIRST)

        assertThat(
            Ranking(LottoNumber(1, 2, 3, 4, 5, 7), LottoNumber(1, 2, 3, 4, 5, 6)).rank
        ).isEqualTo(Ranking.Rank.SECOND)
    }

    class Ranking(match: Match) {
        val rank: Rank = Rank.of(match.count)

        constructor(theNumber: LottoNumber, other: LottoNumber) : this(Match(theNumber, other))

        enum class Rank(private val matchCount: Int) {
            FIRST(6),
            SECOND(5);

            private fun same(count: Int): Boolean = matchCount == count

            companion object {
                fun of(count: Int): Rank = values().first { it.same(count) }
            }
        }
    }

    class Match(left: List<Int>, right: List<Int>) {
        val count: Int = left.intersect(right).size
    }
}
