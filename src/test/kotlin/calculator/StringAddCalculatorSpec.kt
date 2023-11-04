package calculator

import calcuator.StringAddCalculator
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringAddCalculatorSpec : FunSpec({
    test("문자열 계산기는 문자열을 입력 받는다") {
        val string = "1"

        shouldNotThrowAny {
            StringAddCalculator.add(string)
        }
    }

    test("빈 문자열 또는 null이 들어오면 0을 반환한다") {
        forAll(
            row(""),
            row(null),
        ) { input ->

            val result = StringAddCalculator.add(input)

            result shouldBe 0
        }
    }
})
