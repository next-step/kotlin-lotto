package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        StringAddCalculator.add(text) shouldBe 0
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "10"])
    fun oneNumber(text: String) {
        StringAddCalculator.add(text) shouldBe Integer.parseInt(text)
    }

    @DisplayName(value = "숫자를 쉼표(,) 구분자로 입력할 경우 숫자의 합을 반환한다.")
    @Test
    fun twoNumbers() {
        StringAddCalculator.add("1,2,5") shouldBe 8
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @Test
    fun colons() {
        StringAddCalculator.add("1,2:3") shouldBe 6
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//!\n3!3"])
    fun customDelimiter(text: String) {
        StringAddCalculator.add(text) shouldBe 6
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n-1", "//;\n-1;0", "-1", "-1,0", "0:-1"])
    fun negative() {
        shouldThrow<RuntimeException> { StringAddCalculator.add("-1") }
    }

    @DisplayName(value = "문자열 계산기에 숫자가 아닌 문자를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["aa", "1,i,3", "!,3"])
    fun notNumber(text: String) {
        shouldThrow<RuntimeException> { StringAddCalculator.add(text) }
    }
}
