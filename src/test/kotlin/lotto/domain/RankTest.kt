package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

@Suppress("NonAsciiCharacters")
class RankTest {
    @ParameterizedTest
    @MethodSource
    fun `일치하는 수에 따라 당첨 순위가 결정된다`(
        stats: MatchStats,
        expected: Rank,
    ) {
        Rank.valueOf(stats) shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `범위 밖의 숫자이면 예외를 던진다`(count: Int) {
        assertThrows<IllegalArgumentException> { Rank.valueOf(MatchStats(count)) }
    }

    companion object {
        @JvmStatic
        private fun `일치하는 수에 따라 당첨 순위가 결정된다`(): List<Arguments> =
            listOf(
                Arguments.of(MatchStats(6), Rank.FIRST),
                Arguments.of(MatchStats(5, true), Rank.SECOND),
                Arguments.of(MatchStats(5), Rank.THIRD),
                Arguments.of(MatchStats(4, true), Rank.FOURTH),
                Arguments.of(MatchStats(4), Rank.FOURTH),
                Arguments.of(MatchStats(3, true), Rank.FIFTH),
                Arguments.of(MatchStats(3), Rank.FIFTH),
                Arguments.of(MatchStats(2, true), Rank.MISS),
                Arguments.of(MatchStats(2), Rank.MISS),
                Arguments.of(MatchStats(1, true), Rank.MISS),
                Arguments.of(MatchStats(1), Rank.MISS),
                Arguments.of(MatchStats(0, true), Rank.MISS),
                Arguments.of(MatchStats(0), Rank.MISS),
            )
    }
}
