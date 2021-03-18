package lottery.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @ParameterizedTest
    @CsvSource("3, FOURTH", "4, THIRD", "5, SECOND", "6, FIRST")
    fun `맞춘 개수에 맞게 등수를 조회한다`(count: Int, expectedRank: Rank) {
        assertThat(Rank.valueOf(count)).isEqualTo(expectedRank)
    }

    @ParameterizedTest
    @CsvSource("3, true", "0, false", "10, false", "5, true")
    fun `맞춘 개수가 등수에 포함되는지 확인한다`(count: Int, isIn: Boolean) {
        assertThat(Rank.isInTheRank(count)).isEqualTo(isIn)
    }

    @Test
    fun `당첨번호와 5개가 일치하고 보너스볼이 있으면 당첨된 것이다`() {
        assertThat(Rank.isInTheRank(5, true)).isTrue()
    }
}
