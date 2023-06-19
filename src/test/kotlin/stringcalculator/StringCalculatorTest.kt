package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import stringcalculator.parser.ExpressionParser

class StringCalculatorTest : StringSpec({
    "주입받은 ExpressionParser로 파싱한 문자열을 모두 더한다." {
        val fakeParser = object : ExpressionParser {
            override fun getOperands(input: String): List<Operand> {
                return input.split(",").map { Operand(it.trim().toInt()) }
            }
        }
        val calculator = StringCalculator(fakeParser)

        calculator.add("1,2,3,4") shouldBe Operand(10)
    }
})
