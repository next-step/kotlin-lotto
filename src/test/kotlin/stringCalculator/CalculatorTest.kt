package stringCalculator

import Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["//;\\n1", "//!\\n"])
    fun `구분자 찾기(구분자 존재)`(content: String) {
        val calculator = Calculator()

        val value = calculator.existDelimiter(content)
        assertThat(value).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:2:5", "1:2,3"])
    fun `구분자 찾기(구분자 미존재)`(content: String) {
        val calculator = Calculator()
        val value = calculator.existDelimiter(content)
        assertThat(value).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\\n1"])
    fun `구분자 목록 조회`(content: String) {
        val calculator = Calculator()

        val value = calculator.getDelimiters(content)

        assertThat(value).containsAll(listOf(";", ",", ":"))
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\\n1;4;3", "1;4,3"])
    fun `숫자 목록 조회`(content: String) {
        val calculator = Calculator()

        val value = calculator.splitToDelimiters(content, listOf(";", ","))

        assertThat(value).containsAll(listOf(1, 4, 3))
    }
}
