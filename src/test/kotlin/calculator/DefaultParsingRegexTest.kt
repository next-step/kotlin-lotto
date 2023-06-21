package calculator

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class DefaultParsingRegexTest {

    @Test
    fun `문자열을 받아 기본 커스텀 구분자가 포함되었는지 확인한다`() {
        val parsingRegex = DefaultParsingRegex()

        parsingRegex.find("//;\n1;2;3") shouldNotBe null
    }

    @Test
    fun `커스텀 구분자가 포함되어있지 않은 경우 null을 반환한다`() {
        val parsingRegex = DefaultParsingRegex()

        parsingRegex.find("1,2,3") shouldBe null
    }
}
