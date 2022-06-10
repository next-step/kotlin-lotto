package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RankTest {

    @ParameterizedTest
    @MethodSource("rankArguments")
    fun `get Rank from matched`(matched: Int, rank: Rank) {

        assertThat(Rank.of(matched)).isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun rankArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FOURTH),
                Arguments.of(2, Rank.LOSE),
                Arguments.of(1, Rank.LOSE),
                Arguments.of(0, Rank.LOSE),
            )
        }
    }
}
