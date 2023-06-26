package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환") {
        withData(
            null to 0,
            "" to 0,
            "1,2" to 3,
            "1,2,3" to 6,
            "1,2:3" to 6,
            "1:2:3" to 6,
            "1,2:3,4" to 10,
        ) { (input, expected) ->
            StringPlusCalculator.calculate(input) shouldBe expected
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
            StringPlusCalculatorParser.parse(input) shouldBe expected
        }
    }

    context("커스텀 구분자는 문자열 앞부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.") {
        // 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
        withData(
            "//;\n1;2;3" to 6,
            "//;\n1;2;3;4" to 10,
            "//;\n1;2;3;4;5" to 15,
        ) { (input, expected) ->
            StringPlusCalculator.calculate(input) shouldBe expected
        }
    }

    context("숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw") {
        withData(
            "1,2,-3" to RuntimeException("음수는 입력할 수 없습니다."),
            "1,2:3,-4" to RuntimeException("음수는 입력할 수 없습니다."),
            "a,2:3,-4" to RuntimeException("숫자 이외의 값은 입력할 수 없습니다."),
        ) { (input, expected) ->
            shouldThrow<RuntimeException> {
                StringPlusCalculator.calculate(input)
            }.message shouldBe expected.message
        }
    }
})
