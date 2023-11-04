package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null이 입력된 경우 0이 반환된다`(input: String?) {
        assertThat(StringAddCalculator.sum(input)).isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "99"])
    fun `단 하나의 숫자만 오는 경우 그 숫자가 반환된다`(input: String) {
        assertThat(StringAddCalculator.sum(input)).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2=3",
            "1,2,3=6",
            "1,2,3,4,5,6,7,8,9=45"
        ],
        delimiter = '='
    )
    fun `쉼표로 구분된 경우 각 숫자의 합이 반환된다`(input: String, expected: Int) {
        assertThat(StringAddCalculator.sum(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1:2=3",
            "1:2:3=6",
            "1:2:3:4:5:6:7:8:9=45"
        ],
        delimiter = '='
    )
    fun `콜론으로 구분된 경우 각 숫자의 합이 반환된다`(input: String, expected: Int) {
        assertThat(StringAddCalculator.sum(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "1:2,3=6",
            "1:2,3:4:5:6,7:8,9=45"
        ],
        delimiter = '='
    )
    fun `콜론과 쉼표로 구분된 경우 각 숫자의 합이 반환된다`(input: String, expected: Int) {
        assertThat(StringAddCalculator.sum(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "//;\n1;2;3",
            "//^\n1^2^3"
        ]
    )
    fun `커스텀 구분자로 구분된 경우 각 숫자의 합이 반환된다`(input: String) {
        assertThat(StringAddCalculator.sum(input)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "//;\n1;2,3",
            "//^\n1^2:3"
        ]
    )
    fun `커스텀 구분자와 콜론, 쉼표로 구분된 경우 각 숫자의 합이 반환된다`(input: String) {
        assertThat(StringAddCalculator.sum(input)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "1:2:-3", "1,-2,3", "//^\n-1^2^3"])
    fun `음수가 입력된 경우 RuntimeException이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            StringAddCalculator.sum(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["*", "1:3^2", "//&\n8&(2"])
    fun `숫자 이외의 문자가 입력된 경우 RuntimeException이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            StringAddCalculator.sum(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.2", "1,2.3,5", "//&\n8&2.3"])
    fun `정수가 아닌 경우 RuntimeException이 발생한다`(input: String) {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            StringAddCalculator.sum(input)
        }
    }
}
