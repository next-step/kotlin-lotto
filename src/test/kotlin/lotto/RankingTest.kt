package lotto

import lotto.LottoDrawMachineTest.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankingTest {
    @ParameterizedTest(name = "1,2,3,4,5,6 과 {0} 의 랭킹은 {1} 이다")
    @CsvSource(
        value = [
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,45:SECOND",
            "1,2,3,4,44,45:THIRD",
            "1,2,3,43,44,45:FOURTH",
            "1,2,42,43,44,45:MISS"
        ],
        delimiter = ':'
    )
    fun `두 번호그룹을 비교하여 일치수를 알 수 있다`(pick: String, rank: Ranking.Rank) {
        val winningNumber = LottoNumber(1, 2, 3, 4, 5, 6)
        val pickNumbers: List<Int> = pick.split(",").map { it.toInt() }
        assertThat(
            Ranking(winningNumber, LottoNumber(pickNumbers)).rank
        ).isEqualTo(rank)
    }

    class Ranking(match: Match) {
        val rank: Rank = Rank.of(match.count)

        constructor(theNumber: LottoNumber, other: LottoNumber) : this(Match(theNumber, other))

        enum class Rank(private val matchCount: Int) {
            FIRST(6),
            SECOND(5),
            THIRD(4),
            FOURTH(3),
            MISS(0);

            private fun same(count: Int): Boolean = matchCount == count

            companion object {
                fun of(count: Int): Rank = values().firstOrNull { it.same(count) } ?: MISS
            }
        }
    }

    class Match(left: List<Int>, right: List<Int>) {
        val count: Int = left.intersect(right).size
    }
}
