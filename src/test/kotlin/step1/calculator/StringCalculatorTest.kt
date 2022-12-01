package step1.calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class StringCalculatorTest : StringSpec({
    "구분자와 항으로 이루어진 문자열이 문자열 덧셈 계산기에 주어지면 합산된 결과를 반환한다." {
        expressions.forAll { (given: String, actual: Int) ->
            StringCalculator.calculate(given) shouldBe actual
        }
    }
}) {
    companion object {
        private const val actual = 6
        val expressions = listOf(
            "1,2,3" to actual,
            "1:2:3" to actual,
            "1,2:3" to actual,
            "//;\n1;2;3" to actual
        )
    }
}
