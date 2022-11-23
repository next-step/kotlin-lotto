package calculator.study

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull

class RegexStudyTest : FreeSpec({

    val customDelimiterPrefix = "//"
    val customDelimiterSuffix = "\n"
    val regexLiteral = "$customDelimiterPrefix(.*)$customDelimiterSuffix(.*)"

    "Regex(정규식).find(문자열)로 구분자로 시작 문자열과 끝 문자열을 찾을 수 있다." - {
        listOf(
            "$customDelimiterPrefix;$customDelimiterSuffix",
            "$customDelimiterPrefix;${customDelimiterSuffix}1;1",
            "$customDelimiterPrefix!!${customDelimiterSuffix}1!!1"
        ).forEach { text: String ->
            "${text}는 \"//으로 시작하고 \n으로 끝난다.\"" {
                Regex(regexLiteral).find(text).shouldNotBeNull()
            }
        }
    }
})
