package stringcalculator.parser

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import stringcalculator.Operand

class RegexExpressionParserTest : StringSpec({
    ",를 구분자로 사용할 수 있다." {
        testRegexExpressionParser(
            input = "1,2,3",
            result = listOf(1, 2, 3)
        )
    }

    ":를 구분자로 사용할 수 있다." {
        testRegexExpressionParser(
            input = "1:23",
            result = listOf(1, 23)
        )
    }

    """"//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.""" {
        testRegexExpressionParser(
            input = """//;\n1;2;3""",
            result = listOf(1, 2, 3)
        )
        testRegexExpressionParser(
            input = """//*\n1*2*3""",
            result = listOf(1, 2, 3)
        )
    }

    """, : 또는  //와 \n 문자 사이에 커스텀 구분자를 지정하여 사용할 수 있다. """ {
        testRegexExpressionParser(
            input = """//;\n1;12,13:22;23""",
            result = listOf(1, 12, 13, 22, 23)
        )
    }

    """, : 또는  //와 \n 문자 사이에 커스텀 구분자 외에 다른 구분자가 포함되면 예외를 던진다.""" {
        shouldThrow<NumberFormatException> {
            testRegexExpressionParser(
                input = """//;\n1*12,13:22;23""",
                result = listOf(1, 12, 13, 22, 23)
            )
        }
    }
})

private fun testRegexExpressionParser(input: String, result: List<Int>) {
    RegexExpressionParser.getOperands(input) shouldBe crateOperandList(result)
}

private fun crateOperandList(input: List<Int>): List<Operand> {
    return input.map { Operand(it) }
}
