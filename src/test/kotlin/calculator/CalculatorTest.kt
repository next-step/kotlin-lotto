package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "//!\\n1, !",
        "//a\\n1, a",
        "//:\\n1, :",
        "///\\n1, /",
        "////\\n1, //",
        "//???\\n1, ???",
        "1, ",
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

    @ParameterizedTest
    @MethodSource("숫자 parsing 테스트 데이터")
    fun `주어진 구분자로 숫자 parsing 테스트`(inputString: String, separators: Array<String>, numbers: List<Int>) {
        assertThat(
            InputParser(inputString).numbers(separators)
        ).isEqualTo(numbers)
    }

    @ParameterizedTest
    @ValueSource(strings = arrayOf("-1,2,3", "1,a,3"))
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException throw`(inputString: String) {
        assertThatThrownBy {
            InputParser(inputString).numbers()
        }.isInstanceOf(RuntimeException::class.java)
    }

    companion object {
        @JvmStatic
        private fun `숫자 parsing 테스트 데이터`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//!\\n1!2!3", arrayOf("!"), listOf(1, 2, 3)),
                Arguments.of("1;2;3", arrayOf(";"), listOf(1, 2, 3)),
                Arguments.of("1,2:3", emptyArray<String>(), listOf(1, 2, 3)),
                Arguments.of("1,2,3", emptyArray<String>(), listOf(1, 2, 3)),
            )
        }
    }
}


