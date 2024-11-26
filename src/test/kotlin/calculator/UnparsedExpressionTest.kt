package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class UnparsedExpressionTest {

    @Test
    fun `입력 값이 null 이면 0을 반환한다`() {
        val expression = UnparsedExpression(null)
        expression.text shouldBe "0"
    }

    @Test
    fun `입력값이 공백이면 0을 반환한다`() {
        val expression = UnparsedExpression("")
        expression.text shouldBe "0"
    }

    @Test
    fun `입력값을 쉽표 구분자로 분리 할 수 있다`() {
        val expression = UnparsedExpression("1,2,3,4")
        val textTokens = expression.splitText()
        textTokens.findToken()[0] shouldBe PositiveNumber.of("1")
        textTokens.findToken()[1] shouldBe PositiveNumber.of("2")
        textTokens.findToken()[2] shouldBe PositiveNumber.of("3")
        textTokens.findToken()[3] shouldBe PositiveNumber.of("4")
    }

    @Test
    fun `입력값을 콜론 구분자로 분리 할 수 있다 `() {
        val expression = UnparsedExpression("11:22:33:44")
        val textTokens = expression.splitText()
        textTokens.findToken()[0] shouldBe PositiveNumber.of("11")
        textTokens.findToken()[1] shouldBe PositiveNumber.of("22")
        textTokens.findToken()[2] shouldBe PositiveNumber.of("33")
        textTokens.findToken()[3] shouldBe PositiveNumber.of("44")
    }


    @ParameterizedTest
    @ValueSource(strings = ["//@\n1@2@3", "//;\n1;2;3"])
    fun `커스텀 구분자로 분리할수 있다3`(text: String) {
        val expression = UnparsedExpression(text)
        val textTokens = expression.splitText()
        textTokens.findToken()[0] shouldBe PositiveNumber.of("1")
        textTokens.findToken()[1] shouldBe PositiveNumber.of("2")
        textTokens.findToken()[2] shouldBe PositiveNumber.of("3")
    }

    @ParameterizedTest
    @MethodSource("providedOneNumber")
    fun `숫자 하나를 입력하면 해당 숫자를 반환한다`(
        text: String,
        result: String,
        ) {
        val expression = UnparsedExpression(text)
        val textTokens = expression.splitText()
        textTokens.findToken()[0] shouldBe PositiveNumber.of(result)
    }

    companion object {
        @JvmStatic
        fun providedOneNumber() =
            listOf(
                Arguments.arguments("111", "111"),
                Arguments.arguments("5", "5"),
                Arguments.arguments("10000", "10000"),
            )
    }
}