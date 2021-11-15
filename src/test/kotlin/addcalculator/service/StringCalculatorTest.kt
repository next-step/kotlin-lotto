package addcalculator.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {

    private lateinit var stringCalculator: StringCalculator

    @ParameterizedTest
    @CsvSource(value = ["3,2,3=8", "7:8,10=25"], delimiter = '=')
    fun `문자열 더하기 연산 (통합테스트 기본구분자)`(inputValue: String, expected: Int) {
        // given
        stringCalculator = StringCalculator(inputValue)

        // when
        val actual = stringCalculator.calculator()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `문자열 더하기 연산 (통합테스트 커스텀 구분자)`() {
        // given
        stringCalculator = StringCalculator("//;\n1;2;3")

        // when
        val actual = stringCalculator.calculator()

        // then
        assertThat(actual).isEqualTo(6)
    }
}
