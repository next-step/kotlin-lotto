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
    fun `일치하는 수에 따른 당첨 순위가 결정된다`(
        count: Int,
        expected: Rank,
    ) {
        Rank.valueOf(count) shouldBe expected
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 7])
    fun `범위 밖의 숫자이면 예외를 던진다`(count: Int) {
        assertThrows<IllegalArgumentException> { Rank.valueOf(count) }
    }

    companion object {
        @JvmStatic
        private fun `일치하는 수에 따른 당첨 순위가 결정된다`(): List<Arguments> =
            listOf(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.THIRD),
                Arguments.of(4, Rank.FOURTH),
                Arguments.of(3, Rank.FIFTH),
                Arguments.of(2, Rank.MISS),
                Arguments.of(1, Rank.MISS),
                Arguments.of(0, Rank.MISS),
            )
    }
}
