package calculator.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorParserSpec : DescribeSpec({
    describe("문자열 덧셈 계산기 파서") {
        context("기본 구분자와 함께 문자열이 주어진 경우") {
            val ts = listOf(
                "1" to listOf(1),
                "1,2" to listOf(1, 2),
                "1,2,3" to listOf(1, 2, 3),
                "1,2:3" to listOf(1, 2, 3),
                "1,2:3,4" to listOf(1, 2, 3, 4),
            )

            withData(
                nameFn = { "입력 문자열 `${it.first}`에서 (0을 포함한)양수 목록${it.second}을 반환한다." },
                ts = ts,
            ) { (input, answer) ->
                StringCalculatorParser.getPositiveNumbers(input) shouldBe answer
            }
        }

        context("커스텀 구분자와 함께 문자열이 주어진 경우") {
            val ts = listOf(
                "//;\n1" to listOf(1),
                "//;\n1;2;3" to listOf(1, 2, 3),
                "//#\n1#2#3#4" to listOf(1, 2, 3, 4),
            )

            withData(
                nameFn = { "입력 문자열 `${it.first}`에서 (0을 포함한)양수 목록${it.second}을 반환한다." },
                ts = ts,
            ) { (input, answer) ->
                StringCalculatorParser.getPositiveNumbers(input) shouldBe answer
            }
        }
    }
})
