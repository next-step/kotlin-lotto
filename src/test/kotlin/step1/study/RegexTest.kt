package step1.study

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beInstanceOf

class RegexTest : StringSpec({
    "Kotlin 정규표현식 Regex 객체 생성 방법" {
        val regularExpression = "[0-9|a-z]]"

        forAll(
            row("Regex 클래스 생성자를 이용한 객체 생성", Regex(regularExpression)),
            row("String 클래스의 확장함수 toRegex()를 이용한 Regex 객체 생성", regularExpression.toRegex()),
            row("Regex의 fromLiteral()을 이용한 Regex 객체 생성", Regex.fromLiteral(regularExpression)),
            row("삼중 따옴표를 이용한 Regex 객체 생성", """[0-9|a-z]""".toRegex())
        ) { description: String, actual: Regex ->
            actual should beInstanceOf<Regex>()
        }
    }

    "Regex.find() : 정규식과 일치하는 첫 번째 요소 탐색" {
        val actual: MatchResult? = ALPHABET_REGEX_PATTERN.find("abcd")

        actual!!.value shouldBe "a"
        actual.range shouldBe IntRange(0, 0)
    }

    "Regex.find() : 결과값이 없는 경우 null 반환" {
        val actual = ALPHABET_REGEX_PATTERN.find("4")

        actual shouldBe null
    }

    "MatchResult.next() : 정규식과 일치하는 요소 그룹 중 다음 요소 탐색" {
        val actual: MatchResult? = ALPHABET_REGEX_PATTERN.find("abcd")

        actual!!.value shouldBe "a"
        actual.next()!!.value shouldBe "b"
    }

    "콤마 패턴을 이용한 주어진 문자열 처리 학습 테스트" {
        val commaPatternRegex = Regex(COMMA_PATTERN)
        val matchResult: MatchResult? = commaPatternRegex.find(COMMA_EXPRESSION)

        commaPatternRegex.containsMatchIn(COMMA_EXPRESSION) shouldBe true // 패턴과 일치하는 문자열 포함여부
        matchResult!!.value shouldBe "," // 패턴과 일치하는 문자열 추출
        COMMA_EXPRESSION.split(commaPatternRegex).shouldContainExactly("1", "2", "3") // 패턴을 기준으로 값 분리
    }

    "콜론 패턴을 이용한 주어진 문자열 처리 학습 테스트" {
        val colonPatternRegex = Regex(COLON_PATTERN)
        val matchResult: MatchResult? = colonPatternRegex.find(COLON_EXPRESSION)

        colonPatternRegex.containsMatchIn(COLON_EXPRESSION) shouldBe true
        matchResult!!.value shouldBe ":"
        COLON_EXPRESSION.split(colonPatternRegex).shouldContainExactly("1", "2", "3")
    }

    "콤마+콜론 패턴을 이용한 주어진 문자열 처리 학습 테스트" {
        val mixedPatternRegex = Regex(MIXED_PATTERN)
        val actual = mixedPatternRegex.split(MIXED_EXPRESSION)

        mixedPatternRegex.containsMatchIn(MIXED_EXPRESSION) shouldBe true // 패턴과 일치하는 문자열 포함여부
        actual.shouldContainExactly("1", "2", "3") // 패턴을 기준으로 값 분리
    }

    "그룹 패턴을 이용하여 커스텀 구분자의 '//(.)'과 일치하는 값 목록 추출" {
        val customDelimiterRegex = "//(.)" // '//'로 시작하여 '\n'을 제외한 모든 문자 1개
        val regex = customDelimiterRegex.toRegex()
        val matchResult: MatchResult? = regex.find(CUSTOM_EXPRESSION)

        matchResult!!.groupValues[0] shouldBe "//;" // '//(.)' 패턴과 일치하는 문자열
        matchResult.groupValues[1] shouldBe ";" // 전체 패턴 '//(.)'과 일치하는 문자열 중 '(.)' 패턴과 일치하는 문자열
    }

    "그룹 패턴을 이용하여 커스텀 구분자의 '\n(.*)'과 일치하는 값 목록 추출" {
        val customDelimiterRegex = """\n(.*)""" // '\n'으로 시작하는 모든 문자
        val regex = customDelimiterRegex.toRegex()
        val matchResult: MatchResult? = regex.find(CUSTOM_EXPRESSION)

        matchResult!!.groupValues[0] shouldBe "\n4;5" // '\n(.*)' 패턴과 일치하는 문자열
        matchResult.groupValues[1] shouldBe "4;5" // 전체 패턴 '\n(.*)'과 일치하는 문자열 중 '(.*)' 패턴과 일치하는 문자열
    }

    "커스텀 패턴을 이용한 주어진 문자열 처리 학습 테스트" {
        val customPatternRegex = Regex(CUSTOM_PATTERN)
        val actual = customPatternRegex.find(CUSTOM_EXPRESSION)

        customPatternRegex.containsMatchIn(CUSTOM_EXPRESSION) shouldBe true // 포함여부
        actual!!.groupValues[0] shouldBe "//;\n4;5" // '//(.)\n(.*)' 패턴과 일치하는 문자열
        actual.groupValues[1] shouldBe ";" // 전체 패턴 '//(.)\n(.*)'과 일치하는 문자열 중 group 패턴인 '(.)'과 일치하는 문자열
        actual.groupValues[2] shouldBe "4;5" // 전체 패턴 '//(.)\n(.*)'과 일치하는 문자열 중 group 패턴인 '(.*)'과 일치하는 문자열
    }
}) {
    companion object {
        private const val ALPHABET_PATTERN = "[a-z]"
        private val ALPHABET_REGEX_PATTERN = Regex(ALPHABET_PATTERN)

        private const val COMMA_EXPRESSION = "1,2,3"
        private const val COMMA_PATTERN = ","

        private const val COLON_EXPRESSION = "1:2:3"
        private const val COLON_PATTERN = ":"

        private const val MIXED_EXPRESSION = "1,2:3"
        private const val MIXED_PATTERN = "[,:]"

        private const val CUSTOM_EXPRESSION = "//;\n4;5"
        private const val CUSTOM_PATTERN = """//(.)\n(.*)""" // 삼중 문자열 내에서 escape 없이 표현 가능
    }
}
