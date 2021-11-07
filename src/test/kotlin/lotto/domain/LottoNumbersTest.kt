package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoNumbersTest {

    @Test
    fun `6개의 숫자로 LottoNumbers 생성`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val result = LottoNumbers(numbers)

        // then
        val expected = numbers.map { LottoNumber.valueOf(it) }.toSet()
        assertThat(result.numbers).isEqualTo(expected)
    }

    @Test
    fun `겹치는 번호가 있다면 생성할 때 예외 발생`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        // when
        val create: () -> Unit = { LottoNumbers(numbers) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @Test
    fun `번호가 6개보다 적다면 예외 발생`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)

        // when
        val create: () -> Unit = { LottoNumbers(numbers) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @Test
    fun `번호가 6개보다 많다면 예외 발생`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when
        val create: () -> Unit = { LottoNumbers(numbers) }

        // then
        assertThrows<IllegalArgumentException>(create)
    }

    @ParameterizedTest
    @MethodSource
    fun `두 LottoNumbers의 같은 번호 갯수를 센다`(numbers: List<Int>, others: List<Int>, expected: Int) {
        // given
        val lottoNumbers = LottoNumbers(numbers)
        val otherNumbers = LottoNumbers(others)

        // when
        val result = lottoNumbers.countSameNumber(otherNumbers)

        assertThat(result).isEqualTo(expected)
    }

    @Suppress("unused")
    private fun `두 LottoNumbers의 같은 번호 갯수를 센다`() = listOf(
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 7), 5),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 7, 8), 4),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 7, 8, 9), 3),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 7, 8, 9, 10), 2),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 7, 8, 9, 10, 11), 1),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(7, 8, 9, 10, 11, 12), 0),
    )

    @ParameterizedTest
    @MethodSource
    fun `LottoNumbers에 LottoNumber가 포함되어있는지 여부를 구한다`(numbers: List<Int>, number: Int, expected: Boolean) {
        // given
        val lottoNumbers = LottoNumbers(numbers)
        val lottoNumber = LottoNumber.valueOf(number)

        // when
        val result = lottoNumbers.contains(lottoNumber)

        assertThat(result).isEqualTo(expected)
    }

    @Suppress("unused")
    private fun `LottoNumbers에 LottoNumber가 포함되어있는지 여부를 구한다`() = listOf(
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), 1, true),
        Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, false),
        Arguments.of(listOf(7, 8, 9, 10, 11, 12), 1, false),
        Arguments.of(listOf(7, 8, 9, 10, 11, 12), 7, true),
    )
}
