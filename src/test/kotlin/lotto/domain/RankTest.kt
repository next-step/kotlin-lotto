package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RankTest {

    @ParameterizedTest
    @MethodSource("provideRank")
    fun `2등을 제외한 등수 확인`(countOfMatched: Int, bonusMatched: Boolean, expectedRank: Rank) {
        assertThat(Rank.valueOf(countOfMatched, bonusMatched)).isEqualTo(expectedRank)
    }

    companion object {
        @JvmStatic
        fun provideRank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, false, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
            )
        }
    }
}
