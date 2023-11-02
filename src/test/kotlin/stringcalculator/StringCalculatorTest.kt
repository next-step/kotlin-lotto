package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3:6", "1,2;3:6"], delimiter = ':')
    fun `커스텀 구분자 없을 때 쉼표 또는 콜론을 구분자로 문자열을 분리하여 숫자들의 합을 구한다`(target: String, expected: Int) {
        // given
        val stringCalculator = StringCalculator(Validator(), NumberSumCalculator(), StringParser())

        // when
        val result = stringCalculator.sum(target)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `커스텀 구준자가 있을 때 커스텀 구분자로 문자열을 분리하여 숫자들의 함들 구한다`() {
        // given
        val stringCalculator = StringCalculator(Validator(), NumberSumCalculator(), StringParser())
        val target = "//!\n1!2!3"
        val expected = 6

        // when
        val result = stringCalculator.sum(target)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `잘못 입력시 예외를 던진다`() {
        // given
        val stringCalculator = StringCalculator(Validator(), NumberSumCalculator(), StringParser())
        val target = "//!\n1!2!-3"

        // when
        assertThatThrownBy { stringCalculator.sum(target) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0보다 큰 숫자 이여야 한다.")
    }
}
