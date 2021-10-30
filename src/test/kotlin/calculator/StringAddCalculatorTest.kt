package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringAddCalculatorTest {
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(StringAddCalculator.add(text)).isSameAs(ZERO)
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4"])
    fun oneNumber(text: String) {
        assertThat(StringAddCalculator.add(text)).isSameAs(Integer.parseInt(text))
    }

    @TestFactory
    fun twoNumbers() = listOf(
        "1,2" to 3,
        "3,7" to 10
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. $input -> $expected") {
            assertThat(StringAddCalculator.add(input)).isSameAs(expected)
        }
    }

    @TestFactory
    fun colons() = listOf(
        "1,2:3" to 6,
        "3,7:2" to 12
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다. $input -> $expected") {
            assertThat(StringAddCalculator.add(input)).isSameAs(expected)
        }
    }

    @TestFactory
    fun customDelimiter() = listOf(
        "//;\n1;2;3" to 6,
        "//$\n2$3$4" to 9
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다. $input -> $expected") {
            assertThat(StringAddCalculator.add(input)).isSameAs(expected)
        }
    }

    @DisplayName("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "1,-2", "1,2:-3"])
    fun negative(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { StringAddCalculator.add(text) }
    }

    companion object {
        const val ZERO = 0
    }
}
