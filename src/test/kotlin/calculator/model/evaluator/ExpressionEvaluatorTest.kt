package calculator.model.evaluator

import calculator.model.input.InputParser
import calculator.model.operator.AddOperator
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionEvaluatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "//&\n1,2&3=6",
            "//$\n1$2,3:5=11",
            "//#\n1#1#1#1#1#1=6",
            "//^\n3^3=6",
        ],
    )
    fun `커스텀 구분자를 지정하여 덧셈을 진행 가능`(input: String) {
        val parts = input.split('=')
        val numbers = InputParser.parse(parts[0])
        val operator = AddOperator()

        val result =
            ExpressionEvaluator(
                numbers,
                operator,
            ).evaluate()
        result shouldBe parts[1].toInt()
    }
}
