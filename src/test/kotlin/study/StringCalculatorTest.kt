package study

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환") {
        withData(
            "" to 0,
            "1,2" to 3,
            "1,2,3" to 6,
            "1,2:3" to 6,
            "1:2:3" to 6,
            "1,2:3,4" to 10,
        ) { (input, expected) ->
            StringPlusCalculator().calculate(input) shouldBe expected
        }
    }

    context("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리하여 List로 반환") {
        withData(
            "" to emptyList(),
            "1,2" to listOf(1, 2),
            "1,2,3" to listOf(1, 2, 3),
            "1,2:3" to listOf(1, 2, 3),
            "1:2:3" to listOf(1, 2, 3),
            "1,2:3,4" to listOf(1, 2, 3, 4),
        ) { (input, expected) ->
            ParserForStringPlusCalculator.parse(input) shouldBe expected
        }
    }
})
