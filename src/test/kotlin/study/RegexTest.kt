package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RegexTest {
    // ".*"는 문자 0개 이상 의미
    // ".code"는 code로 끝나는 문자열
    // Regex.find() 문자열과 패턴이 완전히 일치하지 않는, 부분적으로만 일치하는 문자열을 찾아줌
    // https://codechacha.com/ko/kotlin-how-to-use-regex/
    @ParameterizedTest
    @ValueSource(strings = ["//;n1;2;3"])
    fun `MatchResult의 groupValues는 부분 매칭하는 문자열을 리턴한다`(inputStr: String) {
        val matchResult = Regex("//(.)n(.*)").find(inputStr)
        matchResult?.let {
            it.groupValues shouldBe listOf("//;n1;2;3", ";", "1;2;3")
            it.groupValues[0] shouldBe "//;n1;2;3"
            it.groupValues[1] shouldBe ";"
            it.groupValues[2] shouldBe "1;2;3"
        }
    }
}
