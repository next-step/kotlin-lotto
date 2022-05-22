package expressioncalculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionInputTest {
    @Test
    fun `ExpressionInput은 숫자로 구분되어야 할 문자열과 구분자를 보관한다`() {
        val delimiter = Delimiter("[,:]")
        val expressionInput = ExpressionInput(Expression("1,2,3"), delimiter)

        assertThat(expressionInput.expression).isEqualTo(Expression("1,2,3"))
        assertThat(expressionInput.delimiter).isEqualTo(delimiter)
    }
}
