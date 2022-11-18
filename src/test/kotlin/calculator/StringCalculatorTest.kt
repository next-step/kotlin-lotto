package calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.RuntimeException

internal class StringCalculatorTest {

    private lateinit var calculator: StringCalculator

    @BeforeEach
    internal fun setUp() {
        calculator = StringCalculator()
    }

    @NullAndEmptySource
    @ParameterizedTest(name = "null 혹은 빈 문자열이 들어가면, 0이 나와야 한다.")
    internal fun inputNullOrEmptyTest(input: String?) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(0)
    }

    @ValueSource(strings = ["1", "2", "3", "10"])
    @ParameterizedTest(name = "숫자 하나`{arguments}` 를 입력받으면, 해당 숫자를 반환한다.")
    internal fun inputSingleNumberTest(input: String) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(input.toInt())
    }


    @CsvSource(value = ["1,2,3=6", "2,5,5=12", "2,5:5=12", "2:3:4=9"], delimiter = '=')
    @ParameterizedTest(name = "[{arguments}] `,` 또는 `:` 을 구분자로 입력한 값의 합을 반환한다.")
    internal fun inputDelimiterTest(input: String, expected: Int) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(expected)
    }


    @CsvSource(value = ["//;\\n1;2;3=6", "//.\\n2.5.5=12"], delimiter = '=')
    @ParameterizedTest(name = "[{arguments}]  `\\` 와 `\n` 사이에 커스텀 구분자로 입력한 값의 합을 반환한다.")
    internal fun inputCustomDelimiterTest(input: String, expected: Int) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ValueSource(strings = ["-1", "-1,5"])
    @ParameterizedTest(name = "[{arguments}] 음수를 입력받으면 RuntimeException 이 발생한다.")
    internal fun inputNegativeNumberExceptionTest(input: String) {
        // given

        // when, then
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.calculate(input) }
    }


}
