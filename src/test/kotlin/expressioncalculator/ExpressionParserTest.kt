package expressioncalculator

import expressioncalculator.model.Delimiter
import expressioncalculator.model.Expression
import expressioncalculator.model.ExpressionInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionParserTest {
    @Test
    fun `ExpressionParser는 ExpressionInput을 받아 Int List로 변환한 뒤 반환한다`() {
        val expressionInput = ExpressionInput(
            expression = Expression("1!2!3"),
            delimiter = Delimiter("!")
        )

        assertThat(ExpressionParser.parse(expressionInput)).isEqualTo(listOf(1, 2, 3))
    }

    @Test
    fun `ExpressionInput의 expression이 비었다면, 빈 리스트를 반환한다`() {
        val expressionInput = ExpressionInput.from(Expression(""))

        assertThat(ExpressionParser.parse(expressionInput)).isEmpty()
    }
}
