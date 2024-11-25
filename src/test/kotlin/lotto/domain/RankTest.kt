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
        count: Int,
        isBonusMatched: Boolean,
        expected: Rank,
    ) {
        Rank.valueOf(count, isBonusMatched) shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `범위 밖의 숫자이면 예외를 던진다`(count: Int) {
        assertThrows<IllegalArgumentException> { Rank.valueOf(count, false) }
    }

    companion object {
        @JvmStatic
        private fun `일치하는 수에 따라 당첨 순위가 결정된다`(): List<Arguments> =
            listOf(
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
