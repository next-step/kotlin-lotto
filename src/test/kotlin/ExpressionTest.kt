import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ExpressionTest {
    @Test
    fun `생성할때 수식을 받는다`() {
        assertThat(Expression("2,3")).isEqualTo(Expression("2,3"))
    }

    @Test
    fun `구분자를 빌드한다`() {
        assertThat(Expression("2,3").delimiters()).isEqualTo(listOf(":", ","))
    }

    @Test
    fun `커스텀 구분자를 빌드한다`() {
        assertThat(Expression("//;\n1;2;3").delimiters()).isEqualTo(listOf(";"))
    }

    @Test
    fun `구문을 빌드한다`() {
        assertAll(
            { assertThat(Expression("1,2").syntax()).isEqualTo("1,2") },
            { assertThat(Expression("//;\n1;2;3").syntax()).isEqualTo("1,2,3") }
        )
    }

    inline class Expression(private val expression: String) {
        private val delimiters: List<String>
            get() {
                return expression.substringBefore(CUSTOM_DELIMITER_SUFFIX)
                    .substringAfter(CUSTOM_DELIMITER_PREFIX, DEFAULT_DELIMITER)
                    .map { it.toString() }
            }

        fun delimiters() = delimiters

        fun syntax() = expression.substringAfter(CUSTOM_DELIMITER_SUFFIX)
            .replace(delimiters().joinToString(","), ",")

        companion object {
            const val CUSTOM_DELIMITER_PREFIX = "//"
            const val CUSTOM_DELIMITER_SUFFIX = "\n"
            const val DEFAULT_DELIMITER = ":,"
        }
    }
}
