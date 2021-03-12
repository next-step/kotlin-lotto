package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankingTest {
    @ParameterizedTest(name = "1,2,3,4,5,6 과 {0} 의 랭킹은 {1} 이다")
    @CsvSource(
        value = [
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,45:THIRD",
            "1,2,3,4,44,45:FOURTH",
            "1,2,3,43,44,45:FIFTH",
            "1,2,42,43,44,45:MISS"
        ],
        delimiter = ':'
    )
    fun `두 번호그룹을 비교하여 일치수를 알 수 있다`(pick: String, rank: Ranking.Rank) {
        val winningNumber = WinningNumbers(LottoNumbers(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val pickNumbers: List<Int> = pick.split(",").map { it.toInt() }
        assertThat(
            Ranking(winningNumber, LottoNumbers(pickNumbers)).rank()
        ).isEqualTo(rank)
    }
}
