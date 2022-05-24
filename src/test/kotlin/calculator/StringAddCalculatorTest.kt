package calculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
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
    fun `1) 빈 문자열 또는 null을 입력한 경우 0을 반환해야 한다`(text: String?) {
        Assertions.assertThat(calculator.add(text)).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["1","3","5"])
    fun `2) 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        Assertions.assertThat(calculator.add(text)).isEqualTo(text.toInt())
    }

    @ParameterizedTest
    @CsvSource("3,2/ 5",
        "3,4,5/ 12",
        delimiter = '/')
    fun `3) 숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, result: Int) {
        Assertions.assertThat(calculator.add(text)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("3:2/ 5",
        "3:4:5/ 12",
        delimiter = '/')
    fun `4) 숫자 두개를 콜론 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, result: Int) {
        Assertions.assertThat(calculator.add(text)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("3:2,4/ 9",
        "3,4:5/ 12",
        delimiter = '/')
    fun `5) 숫자 두개를 혼합(컴마,콜론) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, result: Int) {
        Assertions.assertThat(calculator.add(text)).isEqualTo(result)
    }
}