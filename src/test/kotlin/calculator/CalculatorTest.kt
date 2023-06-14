package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "//!\\n1;2;3, !",
        "//a\\n1;2;3, a",
        "//:\\n1;2;3, :",
        "///\\n1;2;3, /",
        "////\\n1;2;3, //",
        "//???\\n1;2;3, ???",
        "1;2;3, ",
    )
    fun `입력된 문자열에서 구분자 parsing 테스트`(inputString: String, separator: String?) {
        assertThat(
            InputParser(inputString).separator()
        ).isEqualTo(separator)
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("//1\\n1;2;3", "//11\\n1;2;3"))
    fun `입력된 구분자가 숫자이면 IllegalArgumentException throw`(inputString: String) {
        assertThatThrownBy {
            InputParser(inputString).separator()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}


