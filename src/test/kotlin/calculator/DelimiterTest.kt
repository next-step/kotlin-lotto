package calculator

import calculator.application.parser.model.DelimiterEnum
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DelimiterTest : FreeSpec({
    "구분자의 문자열이 포함된다" - {
        listOf(
            "," to true,
            ":" to true,
            "#" to false
        ).forEach { (delimiter: String, result: Boolean) ->
            "${delimiter}는 enum value 에 포함되어 있는지는 $result 입니다" {
                DelimiterEnum.valuesStringArray().contains(delimiter) shouldBe result
            }
        }
    }
})
