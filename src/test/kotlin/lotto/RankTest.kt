package lotto

import lotto.domain.Rank
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @CsvSource(
        "0, false, NONE",
        "3, false, FIFTH",
        "4, false, FOURTH",
        "5, false, THIRD",
        "5, true, SECOND",
        "6, false, FIRST"
    )
    @ParameterizedTest
    fun `matchCount와 bonusMatched 값이 주어지면 Rank을 반환한다`(
        matchCount: Int,
        isBonusMatched: Boolean,
        expected: Rank
    ) {
        val rank = Rank.of(matchCount, isBonusMatched)
        assertEquals(expected, rank)
    }
}