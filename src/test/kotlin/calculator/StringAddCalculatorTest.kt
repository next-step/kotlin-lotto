package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        StringAddCalculator.add(text) shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "10"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        StringAddCalculator.add(text) shouldBe text.toInt()
    }

    @ParameterizedTest
    @MethodSource("generateTestData")
    fun `숫자 두개를 쉼표 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, expect: Int) {
        StringAddCalculator.add(text) shouldBe expect
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3", "1:2:3"])
    fun `구분자를 쉼표 이외에 콜론을 사용할 수 있다`(text: String) {
        StringAddCalculator.add(text) shouldBe 6
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//h\n1h2h3"])
    fun customDelimiterTest(text: String) {
        StringAddCalculator.add(text) shouldBe 6
    }

    @Test
    fun `문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`() {
        shouldThrow<RuntimeException> { StringAddCalculator.add("-1") }
    }

    companion object {
        @JvmStatic
        fun generateTestData(): Stream<Arguments> {
            return Stream.of(
                // input text, output expect result
                Arguments.of("1,2", 3),
                Arguments.of("1,2,3,4,5,6,7,8,9,10", 55),
                Arguments.of("0,0,0", 0),
            )
        }
    }
}
