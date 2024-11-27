package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class Rank2Test {
    @ParameterizedTest
    @MethodSource
    fun `일치하는 수에 따라 당첨 순위가 결정된다`(
        stats: MatchStats,
        expected: Rank2,
    ) {
        Rank2.valueOf(stats) shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `범위 밖의 숫자이면 예외를 던진다`(count: Int) {
        assertThrows<IllegalArgumentException> { Rank2.valueOf(MatchStats(count)) }
    }

    companion object {
        @JvmStatic
        private fun `일치하는 수에 따라 당첨 순위가 결정된다`(): List<Arguments> =
            listOf(
                Arguments.of(MatchStats(6), Rank2.FIRST),
                Arguments.of(MatchStats(5, true), Rank2.SECOND),
                Arguments.of(MatchStats(5), Rank2.THIRD),
                Arguments.of(MatchStats(4, true), Rank2.FOURTH),
                Arguments.of(MatchStats(4), Rank2.FOURTH),
                Arguments.of(MatchStats(3, true), Rank2.FIFTH),
                Arguments.of(MatchStats(3), Rank2.FIFTH),
                Arguments.of(MatchStats(2, true), Rank2.MISS),
                Arguments.of(MatchStats(2), Rank2.MISS),
                Arguments.of(MatchStats(1, true), Rank2.MISS),
                Arguments.of(MatchStats(1), Rank2.MISS),
                Arguments.of(MatchStats(0, true), Rank2.MISS),
                Arguments.of(MatchStats(0), Rank2.MISS),
            )
    }
}
