package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator();
    }

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열 입력할 경우 0을 반환해야 한다`(text: String) {
        val result = calculator.add(text)
        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["1,1", "2,2", "3,3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String, expected: Int) {
        val result = calculator.add(text)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["안녕", "$", "1,2[3"])
    fun `잘못된 문자열을 입력할 경우 RuntimeException`(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add(text) }
            .withMessageMatching("숫자와 지정된 구분자만 입력할 수 있습니다.")
    }

    @Test
    fun `음수를 입력하면 RuntimeException`() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add("-1") }
            .withMessageMatching("음수를 입력할 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `쉼표 또는 콜론 구분자로 숫자를 입력할 경우 정상적으로 합을 반환한다`(text: String) {
        val result = calculator.add(text)
        assertThat(result).isEqualTo(6)
    }
}
