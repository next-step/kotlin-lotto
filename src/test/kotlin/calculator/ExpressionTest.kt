package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ExpressionTest {
    @Test
    fun `생성할때 수식을 받는다`() {
        assertThat(Expression("2,3")).isEqualTo(Expression("2,3"))
    }

    @Test
    fun `구문을 빌드한다`() {
        assertAll(
            { assertThat(Expression("1,2").syntax()).isEqualTo("1,2") },
            { assertThat(Expression("1:2").syntax()).isEqualTo("1,2") },
            { assertThat(Expression("//;\n1;2;3").syntax()).isEqualTo("1,2,3") }
        )
    }

    @Test
    fun `구문의 구분자는 항상 동일하다`() {
        assertAll(
            { assertThat(Expression("1,2").delimiter).isEqualTo(",") },
            { assertThat(Expression("1:2").delimiter).isEqualTo(",") },
            { assertThat(Expression("//;\n1;2;3").delimiter).isEqualTo(",") }
        )
    }

    data class Expression(private val expression: String) {
        val delimiter: String = DEFAULT_DELIMITER

        fun syntax() = expression.substringAfter(CUSTOM_DELIMITER_SUFFIX)
            .replaceAll(delimiters(), DEFAULT_DELIMITER)

        private fun delimiters(): List<String> = expression.substringBetween(
            CUSTOM_DELIMITER_SUFFIX,
            CUSTOM_DELIMITER_PREFIX,
            orElse = DEFAULT_DELIMITERS
        ).map { it.toString() }

        companion object {
            private const val CUSTOM_DELIMITER_PREFIX = "//"
            private const val CUSTOM_DELIMITER_SUFFIX = "\n"
            private const val DEFAULT_DELIMITERS = ":,"
            private const val DEFAULT_DELIMITER = ","
        }

        private fun String.substringBetween(
            open: String,
            close: String,
            orElse: String = this
        ): String {
            return substringBefore(open).substringAfter(close, orElse)
        }

        private fun String.replaceAll(search: List<String>, replacement: String): String {
            var result = this
            for (delimiter in search) {
                result = result.replace(delimiter, replacement)
            }
            return result
        }
    }
}
