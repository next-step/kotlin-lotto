package calculator

import io.kotest.matchers.collections.shouldContainExactly
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
        textTokens.shouldContainExactly(
            PositiveNumber.of("1"),
            PositiveNumber.of("2"),
            PositiveNumber.of("3"),
            PositiveNumber.of("4"),
        )
    }

    @Test
    fun `입력값을 콜론 구분자로 분리 할 수 있다 `() {
        val expression = UnparsedExpression("11:22:33:44")
        val textTokens = expression.splitText()
        textTokens.shouldContainExactly(
            PositiveNumber.of("11"),
            PositiveNumber.of("22"),
            PositiveNumber.of("33"),
            PositiveNumber.of("44"),
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["//@\n1@2@3", "//;\n1;2;3"])
    fun `커스텀 구분자로 분리할수 있다`(text: String) {
        val expression = UnparsedExpression(text)
        val textTokens = expression.splitText()
        textTokens.shouldContainExactly(
            PositiveNumber.of("1"),
            PositiveNumber.of("2"),
            PositiveNumber.of("3"),
        )
    }

    @ParameterizedTest
    @MethodSource("providedOneNumber")
    fun `숫자 하나를 입력하면 해당 숫자를 반환한다`(
        text: String,
        result: String,
    ) {
        val expression = UnparsedExpression(text)
        val textTokens = expression.splitText()
        textTokens.shouldContainExactly(PositiveNumber.of(result))
    }

    @ParameterizedTest
    @ValueSource(strings = [ "//>\n1>2,3:4>5", "//&\n1,2&3&4:5" ])
    fun `커스텀 구분자와 default 구분자를 함께 입력하면 숫자를 분리 할 수있다`(text: String) {
        val expression = UnparsedExpression(text)
        val textTokens = expression.splitText()
        textTokens.shouldContainExactly(
            PositiveNumber.of("1"),
            PositiveNumber.of("2"),
            PositiveNumber.of("3"),
            PositiveNumber.of("4"),
            PositiveNumber.of("5"),
        )
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
