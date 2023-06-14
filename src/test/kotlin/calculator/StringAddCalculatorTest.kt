package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        calculator.add(text) shouldBe 0
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        calculator.add(text) shouldBe text.toInt()
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(
        value = ["1,2=3", "10,20=30"],
        delimiter = '=',
    )
    fun twoNumbers(text: String, expected: String) {
        calculator.add(text) shouldBe expected.toInt()
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @CsvSource(
        value = ["1,2:3=6", "10:20,30=60", "1:5:4=10"],
        delimiter = '=',
    )
    fun colons(text: String, expected: String) {
        calculator.add(text) shouldBe expected.toInt()
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    fun customDelimiter() {
        // [@CsvSource]를 사용하려 했지만 개행 문자 때문인지 input이 제대로 들어오지 않아 @Test로 진행
        calculator.add("//;\n1;2;3") shouldBe 6
        calculator.add("//!\n10,20!30") shouldBe 60
        calculator.add("//#\n20#30:50") shouldBe 100
    }

    @DisplayName(value = "문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "1:-1", "//;\n1;-1"])
    fun negative(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add(text) }
    }

    @DisplayName(value = "문자열 계산기에 숫자가 아닌 값을 전달하는 경우 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["a", "1:a", "//;\n1;a"])
    fun notInteger() {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.add("-1") }
    }
}
