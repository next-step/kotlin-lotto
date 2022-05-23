package expressioncalculator.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExpressionTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "4,5,6", "7,8,9"])
    fun `Expression은 숫자로 구분되어야 할 문자열을 보관한다`(input: String) {
        val expression = Expression(input)

        assertThat(expression.value).isEqualTo(input)
    }
}
