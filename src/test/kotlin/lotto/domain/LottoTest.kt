package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class LottoTest {

    @Test
    fun `로또번호 6개로 로또를 생성할 수 있다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val result = Lotto(lottoNumbers)
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 7])
    fun `로또 생성 시 로또번호 6개가 아닌 경우 예외를 반환한다`(lottoNumberCount: Int) {
        val lottoNumbers = (1..lottoNumberCount).map { LottoNumber(it) }
        val expectedMessage = "로또번호 개수가 6개가 아닙니다."

        val result = assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }

        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `로또 생성 시 중복된 로또번호가 있는 경우 예외를 반환한다`() {
        val lottoNumbers = listOf(1, 1, 2, 3, 4, 5).map { LottoNumber(it) }
        val expectedMessage = "중복된 로또번호가 있습니다."

        val result = assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }

        assertThat(result.message).isEqualTo(expectedMessage)
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "2, true",
        "7, false",
        "8, false"
    )
    fun `로또에 임의의 번호가 존재하는지 확인할 수 있다`(input: Int, expected: Boolean) {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val lotto = Lotto(lottoNumbers)
        val inputNumber = LottoNumber(input)

        val result = lotto.hasNumber(inputNumber)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("provideLottos")
    fun `두 로또에 함께 존재하는 번호 개수를 확인할 수 있다`(number: IntRange, number2: IntRange, expected: Int) {
        val lotto = Lotto(number.map { LottoNumber(it) })
        val other = Lotto(number2.map { LottoNumber(it) })

        val result = lotto.matchedNumberCount(other)

        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun provideLottos(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1..6, 1..6, 6),
                Arguments.of(1..6, 2..7, 5),
                Arguments.of(1..6, 6..11, 1),
                Arguments.of(1..6, 7..12, 0)
            )
        }
    }
}
