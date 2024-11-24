package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @ParameterizedTest
    @CsvSource(
        "3, FOURTH",
        "4, THIRD",
        "5, SECOND",
        "6, FIRST",
    )
    fun `일치갯수로 Rank를 알 수 있다`(matchCount: Int, expected: Rank) {
        val rank = Rank.match(matchCount)

        assertThat(rank).isEqualTo(expected)
    }

    @Test
    fun `prizeRanks 상금목록을 알수 있다`() {
        val prizeRanks = Rank.prizeRanks

        assertThat(prizeRanks).contains(
            Rank.FIRST,
            Rank.SECOND,
            Rank.THIRD,
            Rank.FOURTH,
        )
    }
}
