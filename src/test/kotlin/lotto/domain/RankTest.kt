package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RankTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "6,FIRST,FALSE",
            "5,SECOND,TRUE",
            "5,THIRD,FALSE",
            "4,FOURTH,FALSE",
            "3,FIFTH,FALSE",
            "0,MISS,FALSE"
        ],
        delimiterString = ","
    )
    fun `로또의 당첨 순위 구한다`(matchCount: Int, expect: Rank, matchBonus: Boolean) {
        val result = Rank.find(matchCount, matchBonus)
        assertThat(result).isEqualTo(expect)
    }
}
