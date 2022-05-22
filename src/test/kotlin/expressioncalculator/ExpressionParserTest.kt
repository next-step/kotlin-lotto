package expressioncalculator

import expressioncalculator.model.Delimiter
import expressioncalculator.model.Expression
import expressioncalculator.model.ExpressionInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionParserTest {
    @Test
    fun `ExpressionParser는 ExpressinoInput을 받아 Int List로 변환한 뒤 반환한다`() {
        val expressionInput = ExpressionInput(
            expression = Expression("1!2!3"),
            delimiter = Delimiter("!")
        )

        assertThat(ExpressionParser.parse(expressionInput)).isEqualTo(listOf(1, 2, 3))
    }
}
