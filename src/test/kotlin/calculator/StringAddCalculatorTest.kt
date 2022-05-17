package calculator

import calcaulator.StringAddCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringAddCalculatorTest {

    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        assertThat(calculator.add(text)).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "100"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        assertThat(calculator.add(text)).isSameAs(text.toInt())
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2',3",
        "'1,2,3',6"
    )
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, expected: Int) {
        assertThat(calculator.add(text)).isSameAs(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2:3',6",
        "'1:2:3,4',10"
    )
    fun `구분자를 쉼표(,) 이외에 콜론을 사용할 수 있다`(text: String, expected: Int) {
        assertThat(calculator.add(text)).isSameAs(expected)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @CsvSource(
        "'//;\n1;2;3',6",
        "'//;\n1;2;3;4',10"
    )
    fun customDelimiter(text: String) {
        assertThat(calculator.add(text)).isSameAs(6)
    }
}
