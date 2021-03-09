package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = ["//;\n1;2;3|;", "//,\n1,2,3|,"], delimiter = '|')
    @DisplayName("//와\\n 사이에 있는 값을 구분자로 추출한다")
    fun `구분자를 추출한다`(input: String, delimiters: String) {
        val delimiters: List<String> = Calculator.extractDelimiters(input)

        assertThat(delimiters).isEqualTo(delimiters)
    }
}
