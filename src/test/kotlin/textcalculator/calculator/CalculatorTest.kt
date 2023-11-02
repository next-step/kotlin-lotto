package textcalculator.calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import textcalculator.text.InputString
import java.lang.RuntimeException

class CalculatorTest {
    @Test
    fun `문자열을 입력받는다`() {
        // Given
        val input = "2 , 3 4 2"

        // When
        InputString(input)
    }

    @Test
    fun `문자열을 쉼표와 콜론으로 구분한다`() {
        // Given
        val input = "2 , 3 : 4 2"

        // When
        val inputStrings = InputString(input)

        // Then
        Calculator.splitString(inputStrings.input, inputStrings.delimiters) shouldBe listOf("2", "3", "42")
    }

    @Test
    fun `문자열 계산기에 쉼표와 콜론 이외의 문자가 들어올 경우 RuntimeException`() {
        // Given
        val input = "2 ? 3 ++"

        // When
        assertThrows<RuntimeException> {
            InputString(input)
        }
    }

    @Test
    fun `문자열 계산기에 음수를 전달할 경우 RuntimeException`() {
        // Given
        val input = "-2 + 3"

        // When
        assertThrows<RuntimeException> {
            InputString(input)
        }
    }

    @Test
    fun `문자열 계산기에 커스텀 구분자를 지정할 수 있다`() {
        // Given
        val input = "//;\n1; 2;  3"

        // When
        val inputStrings = InputString(input)

        // Then
        Calculator.splitString(inputStrings.input, inputStrings.delimiters) shouldBe listOf("1", "2", "3")
    }

    @Test
    fun `문자열이 split 된 결과의 합을 반환한다`() {
        // Given
        val input = "//;\n1; 2;  3"

        // When
        val inputStrings = InputString(input)
        val texts = Calculator.splitString(inputStrings.input, inputStrings.delimiters)

        // Then
        Calculator.calculate(texts) shouldBe 6
    }
}
