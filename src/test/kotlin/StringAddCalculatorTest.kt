import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : DescribeSpec({
    data class CommandExpected(val command: String, val expected: Int)

    describe("문자열 덧셈 계산기") {
        context("빈 문자열을 입력하면") {
            it("0을 반환한다") {
                StringAddCalculator.add("") shouldBe 0
            }
        }

        context("공백을 입력하면") {
            it("0을 반환한다") {
                StringAddCalculator.add(" ") shouldBe 0
            }
        }

        context("null을 입력하면") {
            it("0을 반환한다") {
                StringAddCalculator.add(null) shouldBe 0
            }
        }

        context("숫자 하나를 문자열로 입력하면, 해당 숫자를 반환한다") {
            withData(
                nameFn = { "add(\"${it.command}\") =  ${it.expected}" },
                CommandExpected("1", 1),
                CommandExpected("2", 2),
                CommandExpected("3", 3),
            ) { (command, expected) ->
                StringAddCalculator.add(command) shouldBe expected
            }
        }

        context("숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.") {
            withData(
                nameFn = { "add(\"${it.command}\") =  ${it.expected}" },
                CommandExpected("1,1", 2),
                CommandExpected("2,3", 5),
                CommandExpected("3,5", 8),
            ) { (command, expected) ->
                StringAddCalculator.add(command) shouldBe expected
            }
        }
    }

})