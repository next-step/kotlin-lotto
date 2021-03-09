package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CalculatorTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열을 입력할 경우 0을 반환한다`(input: String) {
        val sum = Calculator.add(input)

        assertThat(sum).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "4", "9"])
    fun `하나의 숫자만 입력받았을 경우 해당 값을 그대로 리턴한다`(input: String) {
        val sum = Calculator.add(input)

        assertThat(sum).isSameAs(input.toInt())
    }

    @Test
    fun `입력한 값 중에 음수가 있는 경우 예외처리한다`() {
        assertThrows<IllegalArgumentException> {
            Calculator.add("-1")
        }
    }

    @Test
    fun `쉼표와 콜론을 구분자로 전달한 경우 합을 반환한다`() {
        val result = Calculator.add("1,2,:3")

        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자를 전달한 경우 구분자로 분리된 값들의 합을 반환한다`() {
        val result = Calculator.add("//,\n1,2,3")

        assertThat(result).isEqualTo(6)
    }

}
