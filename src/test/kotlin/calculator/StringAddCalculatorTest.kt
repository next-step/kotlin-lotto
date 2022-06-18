package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈문자열 혹은 null을 입력할 경우 0 반환`(source: String?) {
        assertThat(calculator.add(source)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자만 들어온 경우 해당 숫자를 그대로 반환`(source: String) {
        assertThat(calculator.add(source)).isEqualTo(source.toLong())
    }

    @DisplayName("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = ["1,2/3", "1,2,3/6", "1,2,3,6/12"], delimiterString = "/")
    fun sumSeparatedByComma(text: String, result: Long) {
        assertThat(calculator.add(text)).isEqualTo(result)
    }

    @DisplayName("숫자를 콜론(:)으로 구분하여 입력할 경우 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = ["1:2/3", "1:2:3/6", "1:2:3:6/12"], delimiterString = "/")
    fun sumSeparatedByColon(text: String, result: Long) {
        assertThat(calculator.add(text)).isEqualTo(result)
    }

    @DisplayName("숫자를 콜론(:) 또는 콤마(,)로 구분하여 입력할 경우 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = ["1:2/3", "1,2:3/6", "1:2,3:6/12", "1,2:3,6:12/24"], delimiterString = "/")
    fun sumSeparatedByColonOrComma(text: String, result: Long) {
        assertThat(calculator.add(text)).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "1,2,-4", "-3,2,1"])
    fun `음수 값이 전달되는 경우 예외 발생`(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add(text) }
    }
}
