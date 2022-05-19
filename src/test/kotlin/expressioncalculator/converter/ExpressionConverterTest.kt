package expressioncalculator.converter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionConverterTest {
    @Test
    fun `ExpressionConverter를 구현하여 String을 Int List로 변환하는 클래스를 만들 수 있다`() {
        val expressionConverter = object : ExpressionConverter {
            override fun convert(expression: String): List<Int> {
                return listOf(0)
            }
        }

        assertThat(expressionConverter.convert("test")).isEqualTo(listOf(0))
    }
}
