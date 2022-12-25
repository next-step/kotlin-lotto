package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RankingTest {

    @Test
    fun `당첨된 개수에 맞는 랭킹 반환`() {
        // given
        val matchCount = 5

        // when
        val actual = Ranking.valueOf(matchCount)

        // then
        val expected = Ranking.SECOND
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `당첨 개수가 3개 미만일 경우 Miss 반환`() {
        // given
        val matchCount = 2

        // when
        val actual = Ranking.valueOf(matchCount)

        // then
        val expected = Ranking.MISS
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `당첨된 랭킹의 개수만큼 총 당첨 금액 반환`() {
        // given
        val matchResultValue = 3

        // when
        val actual = Ranking.SECOND.getTotalWinningMoney(matchResultValue)

        // then
        val expected = 4500000
        assertThat(actual).isEqualTo(expected)
    }
}
