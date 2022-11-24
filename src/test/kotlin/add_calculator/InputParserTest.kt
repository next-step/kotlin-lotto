package add_calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class InputParserTest : DescribeSpec({
    describe("InputParser") {
        val inputParser = InputParser()

        context(", 혹은 : 로 구분된 문자열을 입력받으면") {
            val inputString = "3,5:4"
            it("분리된 문자열 배열을 반환한다.") {
                inputParser.parse(inputString) shouldBe listOf(Operand("3"), Operand("5"), Operand("4"))
            }
        }

        context("null, 빈 문자열, 공백이 입력되면 ") {
            it("[\"0\"]을 반환한다.") {
                forAll(
                    row(null), row(""), row(" ")
                ) { inputString: String? ->
                    inputParser.parse(inputString) shouldBe listOf(Operand("0"))
                }
            }
        }

        context("커스텀 구분자가 포함된 구문 \"//;\\n1;2;3\" 입력되면") {
            it("[Operand(1)Operand(2)Operand(3)]을 반환한다.") {
                inputParser.parse("//;\n1;2;3") shouldBe listOf(Operand("1"), Operand("2"), Operand("3"))
            }
        }
    }
})
