package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    private val sut = StringCalculator()

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열이나 null 이 주어지면 0을 반환한다`(input: String?) {
        val result = sut.add(input)

        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "99"])
    fun `숫자 하나를 문자열로 입력 할 경우, 해당 숫자를 반환한다`(input: String) {
        val result = sut.add(input)

        assertThat(result).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "-1"])
    fun `문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다`(input: String) {
        assertThrows<IllegalArgumentException> {
            sut.add(input)
        }
    }

    @ParameterizedTest
    @MethodSource("defaultStringAddProvider")
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환`(input: String, output: Int) {
        val result = sut.add(input)

        assertThat(result).isEqualTo(output)
    }

    @ParameterizedTest
    @MethodSource("customStringAddProvider")
    fun `기본 구분자 외에 커스텀 구분자를 지정할 수 있다`(input: String, output: Int) {
        val result = sut.add(input)

        assertThat(result).isEqualTo(output)
    }

    companion object {
        @JvmStatic
        fun defaultStringAddProvider(): List<Arguments> {
            return listOf(
                Arguments { arrayOf("1,2", 3) },
                Arguments { arrayOf("1,2,3", 6) },
                Arguments { arrayOf("1,2:6", 9) }
            )
        }

        @JvmStatic
        fun customStringAddProvider(): List<Arguments> {
            return listOf(
                Arguments { arrayOf("//-\\n1-2", 3) },
                Arguments { arrayOf("//;\\n1;2;3", 6) }
            )
        }
    }
}
