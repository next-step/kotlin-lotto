package lotto.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinningResultTest {

    @Test
    fun `받은 상금의 총 상금을 계산한다`() {
        // given
        val prizes = listOf(Rank.FOURTH, Rank.FIRST)

        // when
        val result = WinningResult.aggregate(ranks = prizes)

        // then
        val expected = prizes.map { it.prizeAmount }
            .reduce { x, y -> x + y }
            .toPrize()

        assertThat(result.totalPrize).isEqualTo(expected)
    }

    @Test
    fun `받은 상금을 통계표로 조회가능하다`() {
        // given
        val prizes = listOf(Rank.FOURTH, Rank.FIRST, Rank.FIRST, Rank.THIRD)

        // when
        val result = WinningResult.aggregate(ranks = prizes)

        // then
        assertThat(result.findRankCount(Rank.FIRST)).isEqualTo(2)
        assertThat(result.findRankCount(Rank.SECOND)).isEqualTo(0)
        assertThat(result.findRankCount(Rank.THIRD)).isEqualTo(1)
        assertThat(result.findRankCount(Rank.FOURTH)).isEqualTo(1)
        assertThat(result.findRankCount(Rank.FAIL)).isEqualTo(0)
    }
}
