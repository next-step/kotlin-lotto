package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
class LottoLineTest {
    @Test
    fun `숫자를 정렬한다`() {
        val line = LottoLine.from(3, 2, 1, 6, 5, 4)
        val numbers = line.numbers.map { it.value }
        numbers shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    @ParameterizedTest
    @MethodSource
    fun `숫자가 6개가 아니면 예외를 던진다`(values: List<Int>) {
        assertThrows<IllegalArgumentException> { LottoLine.from(values) }
    }

    @Test
    fun `중복이 있으면 에러를 던진다`() {
        assertThrows<IllegalArgumentException> { LottoLine.from(1, 1, 2, 3, 4, 5) }
    }

    @Test
    fun `숫자가 포함되어 있는지 리턴한다`() {
        val line = LottoLine.from(1, 2, 3, 4, 5, 6)
        line.contains(LottoNumber.from(1)) shouldBe true
        line.contains(LottoNumber.from(42)) shouldBe false
    }

    @ParameterizedTest(name = "{index}: 겹치는 숫자의 개수는 {1}")
    @MethodSource
    fun `두 줄간 겹치는 숫자의 개수를 구한다`(
        other: LottoLine,
        expected: Int,
    ) {
        val line = LottoLine.from(1, 2, 3, 4, 5, 6)
        val actual = line.countOverlap(other)
        actual shouldBe expected
    }

    @ParameterizedTest
    @MethodSource
    fun `당첨 순위를 구한다`(
        winner: LottoLine,
        expected: Rank,
    ) {
        val line = LottoLine.from(1, 2, 3, 4, 5, 6)
        val actual = line.match(winner)
        actual shouldBe expected
    }

    companion object {
        @JvmStatic
        private fun `숫자가 6개가 아니면 예외를 던진다`(): List<List<Int>> =
            listOf(
                emptyList(),
                listOf(1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 5, 6, 7),
            )

        @JvmStatic
        private fun `두 줄간 겹치는 숫자의 개수를 구한다`(): List<Arguments> =
            listOf(
                Arguments.of(LottoLine.from(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(LottoLine.from(1, 8, 9, 10, 11, 12), 1),
                Arguments.of(LottoLine.from(1, 2, 3, 4, 5, 6), 6),
            )

        @JvmStatic
        private fun `당첨 순위를 구한다`(): List<Arguments> =
            listOf(
                Arguments.of(LottoLine.from(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(LottoLine.from(1, 2, 3, 4, 5, 7), Rank.THIRD),
                Arguments.of(LottoLine.from(1, 2, 3, 4, 7, 8), Rank.FOURTH),
                Arguments.of(LottoLine.from(1, 2, 3, 7, 8, 9), Rank.FIFTH),
                Arguments.of(LottoLine.from(1, 8, 9, 10, 11, 12), Rank.MISS),
                Arguments.of(LottoLine.from(7, 8, 9, 10, 11, 12), Rank.MISS),
            )
    }
}
