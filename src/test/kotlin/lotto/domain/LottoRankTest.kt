package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoRankTest {

    @CsvSource(
        "0, false, NONE",
        "1, false, NONE",
        "2, false, NONE",
        "3, false, FIFTH",
        "4, false, FOURTH",
        "5, false, THIRD",
        "5, true, SECOND",
        "6, false, FIRST",
    )
    @ParameterizedTest
    fun `matchCount에 의해 LottoRank를 생성한다`(
        matchCount: Int,
        isBonusMatched: Boolean,
        expected: LottoRank,
    ) {
        assertThat(LottoRank.from(matchCount, isBonusMatched)).isEqualTo(expected)
    }
}
