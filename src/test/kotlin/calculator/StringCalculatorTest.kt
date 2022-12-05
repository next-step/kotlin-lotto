package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {

    private lateinit var calculator: StringCalculator

    @BeforeEach
    internal fun setUp() {
        calculator = StringCalculator()
    }

    @NullAndEmptySource
    @ParameterizedTest
    internal fun `null 혹은 빈 문자열이 들어가면, 0이 나온다`(input: String?) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(0)
    }

    @ValueSource(strings = ["\n", "\t"])
    @ParameterizedTest
    internal fun `공백 문자열이 들어가면 0이 나온다`(input: String?) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(0)
    }

    @ValueSource(strings = ["1", "2", "3", "10"])
    @ParameterizedTest
    internal fun `입력받은 숫자가 한개면 해당 숫자를 반환한다`(input: String) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(input.toInt())
    }

    @CsvSource(value = ["1,2,3=6", "2,5,5=12", "2,5:5=12", "2:3:4=9"], delimiter = '=')
    @ParameterizedTest
    internal fun `기본 구분자로 입력한 값의 합을 반환한다`(input: String, expected: Int) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ValueSource(strings = ["//;\n1;2;3", "//.\n1.2.3"])
    @ParameterizedTest
    internal fun `커스텀 구분자로 입력한 값의 합을 반환한다`(input: String) {
        // given

        // when
        val result = calculator.calculate(input)

        // then
        assertThat(result).isEqualTo(6)
    }

    @ValueSource(strings = ["-1", "-1,5"])
    @ParameterizedTest
    internal fun `음수를 입력받으면 RuntimeException 이 발생한다`(input: String) {
        // given

        // when, then
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.calculate(input) }
    }
}
