package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {

    @ParameterizedTest
    @MethodSource("lottoNumbersProvider")
    fun `로또 한장은 로또번호 6개로 구성된다`(
        givenNumbers: List<Int>,
    ) {
        // Given & When
        val actual = Lotto.from(givenNumbers)

        // Then
        assertAll(
            { assertThat(actual.lottoNumbers.size).isEqualTo(6) },
            { assertThat(actual.lottoNumbers).contains(LottoNumber.from(givenNumbers[0])) },
            { assertThat(actual.lottoNumbers).contains(LottoNumber.from(givenNumbers[1])) },
            { assertThat(actual.lottoNumbers).contains(LottoNumber.from(givenNumbers[2])) },
            { assertThat(actual.lottoNumbers).contains(LottoNumber.from(givenNumbers[3])) },
            { assertThat(actual.lottoNumbers).contains(LottoNumber.from(givenNumbers[4])) },
            { assertThat(actual.lottoNumbers).contains(LottoNumber.from(givenNumbers[5])) },
        )
    }

    @ParameterizedTest
    @MethodSource("lottoMakeFailProvider")
    fun `생성시 제공되는 번호의 수가 6개가 아닌 경우, 에러를 반환한다`(
        givenNumbers: List<Int>,
    ) {
        assertThrows<IllegalArgumentException> {
            Lotto.from(givenNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("winningLottoMatchProvider")
    fun `로또 두개를 서로 비교햐여 일치하는 번호의 수를 반환한다`(
        givenNumbers: List<Int>,
        winningNumbers: List<Int>,
        matchCount: Int,
    ) {
        // Given
        val lotto = Lotto.from(givenNumbers)
        val winningLotto = Lotto.from(winningNumbers)

        // When
        val actual = lotto.makeMatchCountByNumbers(winningLotto)

        // Then
        assertThat(actual).isSameAs(matchCount)
    }

    @Test
    fun `로또 생성시 중복된 숫자가 있을 경우 에러를 반환한다`() {
        // Given
        val givenNumbers = listOf(1, 2, 2, 3, 4, 5)

        // When & Then
        assertThrows<IllegalArgumentException> {
            Lotto.from(givenNumbers)
        }
    }

    companion object {
        @JvmStatic
        fun lottoNumbersProvider() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(listOf(7, 8, 9, 10, 11, 12)),
            Arguments.of(listOf(13, 14, 15, 16, 17, 18)),
            Arguments.of(listOf(19, 20, 21, 22, 23, 24)),
            Arguments.of(listOf(25, 26, 27, 28, 29, 30)),
            Arguments.of(listOf(31, 32, 33, 34, 35, 36)),
            Arguments.of(listOf(37, 38, 39, 40, 41, 42)),
            Arguments.of(listOf(43, 44, 45, 1, 2, 3)),
        )

        @JvmStatic
        fun lottoMakeFailProvider() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 4, 5)),
            Arguments.of(listOf(1)),
        )

        @JvmStatic
        fun winningLottoMatchProvider() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 2, 3, 4, 5, 6), 5),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 12, 3, 4, 5, 6), 4),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 12, 13, 4, 5, 6), 3),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 12, 13, 14, 5, 6), 2),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 12, 13, 14, 15, 6), 1),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(11, 12, 13, 14, 15, 16), 0),
        )
    }
}
