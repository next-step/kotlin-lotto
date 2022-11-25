package calculator

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class StringCalculatorTest {

    @Test
    fun `빈 문자열일 경우 0을 반환한다`() {
        val mathematical = ""
        val calculator = StringCalculator()
        assertThat(calculator.calculate(mathematical)).isEqualTo(0)
    }

    @Test
    fun `null일 경우 0을 반환한다`() {
        val mathematical = ""
        val calculator = StringCalculator()
        assertThat(calculator.calculate(mathematical)).isEqualTo(0)
    }

    @ParameterizedTest
    @MethodSource("stringToResults")
    fun `기본 구분자일 때 문자열을 Split하여 계산한다` (mathematical: String, expect: Long) {

        val calculator = StringCalculator()
        val result = calculator.calculate(mathematical)
        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @MethodSource("customSeparatorStringToResults")
    fun `커스텀 구분자일 때 문자열을 Split하여 계산한다`(mathematical: String, expect: Long) {
        val calculator = StringCalculator()
        val result = calculator.calculate(mathematical)
        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `수식에 문자가 들어오면 예외를 발생시킨다`() {
        val mathematical = "a:1:2"
        val calculator = StringCalculator()
        assertThrows<IllegalArgumentException> {
            calculator.calculate(mathematical)
        }
    }

    @Test
    fun `수식에 음수가 들어오면 예외를 발생시킨다`() {
        val mathematical = "1,-1:2"
        val calculator = StringCalculator()
        assertThrows<IllegalArgumentException> {
            calculator.calculate(mathematical)
        }
    }

    companion object {
        @JvmStatic
        fun stringToResults(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1,2,3", 6L),
                Arguments.arguments("4:5:1", 10L),
                Arguments.arguments("4:2,3", 9L)
            )
        }

        @JvmStatic
        fun customSeparatorStringToResults(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("//;\n1;2;3", 6L),
                Arguments.arguments("//!\n1!1!4", 6L),
                Arguments.arguments("//#\n2#0#1", 3L),
            )
        }
    }
}