package lottoTest

import lotto.domain.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RankTest {
    @ParameterizedTest
    @MethodSource("generateRankArguments")
    fun `일치하는 숫자의 수와 보너스 숫자 일치 여부로 Rank를 찾음`(countOfMatch: Int, matchBonus: Boolean, expectedRank: Rank) {
        assertEquals(expectedRank, Rank.valueOf(countOfMatch, matchBonus))
    }

    companion object {
        @JvmStatic
        fun generateRankArguments(): List<Arguments> {
            return listOf<Arguments>(
                Arguments.of(6, true, Rank.FIRST),
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.MISS),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(1, true, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(0, true, Rank.MISS),
                Arguments.of(0, false, Rank.MISS),
            )
        }
    }
}
