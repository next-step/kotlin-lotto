package calculator

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "''|0",
            "1,2|3",
            "1,2,3|6",
            "1,2:3|6"
        ],
        delimiter = '|'
    )
    fun `string sub calculator test`(input: String, result: Int) {
        assertThat(Calculator(input).sum()).isEqualTo(result)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings  = ["//;\n1;2;3"])
    fun `string custom delimeter calculator test`(input: String) {
        assertThat(Calculator(input).sum()).isEqualTo(6)
    }

    @Test
    fun `negative input test`() {
        assertThatThrownBy { Calculator("-1").sum() }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageMatching("양수만 입력해주세요.")
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "한글",
            "1,2|3",
            "dfas,dfasd:fas"
        ]
    )
    fun `illegal input test`(input: String) {
        assertThatThrownBy { Calculator(input).sum() }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessageMatching("숫자 또는 구분자만 입력해주세요.")
    }
}