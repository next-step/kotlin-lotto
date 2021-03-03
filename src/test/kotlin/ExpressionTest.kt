import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionTest {
    @Test
    fun `생성할때 수식을 받는다`() {
        assertThat(Expression("2,3")).isEqualTo(Expression("2,3"))
    }

    @Test
    fun `구분자를 빌드한다`() {
        assertThat(Expression("2,3").delimiters()).isEqualTo(listOf(",", ":"))
    }

    @Test
    fun `커스텀 구분자를 빌드한다`() {
        assertThat(Expression("//;\n1;2;3").delimiters()).isEqualTo(listOf(";"))
    }

    inline class Expression(private val expression: String) {
        fun delimiters() = listOf(",", ":")
    }
}
