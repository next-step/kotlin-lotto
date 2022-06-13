package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RankTest {

    @ParameterizedTest
    @MethodSource("rankArguments")
    fun `get Rank from matched`(countOfMatch: Int, matchedBonus: Boolean, rank: Rank) {

        assertThat(Rank.of(countOfMatch, matchedBonus)).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun rankArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.LOSE),
                Arguments.of(1, false, Rank.LOSE),
                Arguments.of(0, false, Rank.LOSE),
            )
        }
    }
}
