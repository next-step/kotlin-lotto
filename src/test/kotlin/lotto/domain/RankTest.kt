package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RankTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "6,FIRST",
            "5,SECOND",
            "4,THIRD",
            "3,FOURTH",
            "1,MISS",
            "0,MISS"
        ],
        delimiterString = ","
    )
    fun `로또의 당청 금액을 구한다`(matchCount: Int, expect: Rank) {
        val result = Rank.find(matchCount)
        assertThat(result).isEqualTo(expect)
    }
}
