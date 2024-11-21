package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        calculator.add(text) shouldBe 0
    }

    @Test
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`() {
        val text = "1"
        calculator.add(text) shouldBe 1
    }

    @Test
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`() {
        val text = "1,2"
        calculator.add(text) shouldBe 3
    }

    @Test
    fun `구분자를 쉼표(,) 이외에 콜론을 사용할 수 있다`() {
        val text = "1,2:3"
        calculator.add(text) shouldBe 6
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    fun customDelimiter() {
        val text = "//;\n1;2;3"
        calculator.add(text) shouldBe 6
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "a,b", ",,,", ":::::::"])
    fun `잘못된 입력값이 들어오면 예외 발생한다`(text: String) {
        shouldThrow<RuntimeException> { calculator.add(text) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-100", "-999999"])
    fun `문자열 계산기에 음수를 전달하는 경우 예외 발생한다`(text: String) {
        shouldThrow<RuntimeException> { calculator.add(text) }
    }
}
