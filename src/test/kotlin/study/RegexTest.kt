package study

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.util.regex.PatternSyntaxException

class RegexTest {
    @Test
    fun `메타 문자를 이스케이프 처리하지 않은 경우 Regex 생성 시 예외가 발생한다`() {
        val delimiters = listOf(",", ":", "+")
        val invalidRegex = delimiters.joinToString("|")

        assertThatThrownBy { invalidRegex.toRegex() }.isInstanceOf(PatternSyntaxException::class.java)
    }

    @Test
    fun `메타 문자를 이스케이프 처리한 Regex는 올바르게 작동한다`() {
        val delimiters = listOf(",", ":", "+")
        val escapedDelimiters = delimiters.joinToString("|") { Regex.escape(it) }
        val actualRegex = Regex(escapedDelimiters)

        val expectedRegex = Regex("\\Q,\\E|\\Q:\\E|\\Q+\\E")
        expectedRegex.pattern shouldBe actualRegex.pattern
    }

    @Test
    fun `Regex_escape는 특수 문자를 Q와 E로 감싸 패턴을 생성한다`() {
        val input = "+*?."

        val escaped = Regex.escape(input)

        val expected = "\\Q+*?.\\E"
        escaped shouldBe expected
    }
}
