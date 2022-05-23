package expressioncalculator

import expressioncalculator.model.Expression
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputConverterTest {
    @Test
    fun `InputConverter는 커스텀 구분자가 존재한다면, 사용자의 입력을 커스텀 구분자와 문자열로 나눈 뒤 ExpressionInput으로 변환해 준다`() {
        val input = "//;\n1;2;3"
        val expressionInput = InputConverter.convert(input)

        assertThat(expressionInput.expression).isEqualTo(Expression("1;2;3"))
        assertThat(expressionInput.delimiter.value.pattern).isEqualTo(";")
    }

    @Test
    fun `InputConverter는 커스텀 구분자가 존재하지 않는다면 입력 문자열 그대로 ExpressionInput으로 변환해 준다`() {
        val input = "1,2,3"
        val expressionInput = InputConverter.convert(input)

        assertThat(expressionInput.expression).isEqualTo(Expression(input))
    }
}
