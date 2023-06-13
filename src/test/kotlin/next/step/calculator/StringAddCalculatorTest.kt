package next.step.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringAddCalculatorTest : DescribeSpec({
    data class CommandExpected(val command: String?, val expected: Int)

    describe("문자열 덧셈 계산기") {
        context("null을 입력하면") {
            it("0을 반환한다") {
                StringAddCalculator.add(null) shouldBe 0
            }
        }

        context("white space를 입력하면 0을 반환한다.") {
            withData(
                nameFn = { "add(\"${it.command}\") =  ${it.expected}" },
                CommandExpected("", 0),
                CommandExpected(" ", 0),
                CommandExpected("\t", 0),
                CommandExpected("\n", 0),
            ) { (command, expected) ->
                StringAddCalculator.add(command) shouldBe expected
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
                CommandExpected("2,3,5", 10),
                CommandExpected("3,5,6,11", 25),
            ) { (command, expected) ->
                StringAddCalculator.add(command) shouldBe expected
            }
        }

        context("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.") {
            withData(
                nameFn = { "add(\"${it.command}\") =  ${it.expected}" },
                CommandExpected("1:15", 16),
                CommandExpected("2:3,5", 10),
                CommandExpected("3,5:6:11", 25),
            ) { (command, expected) ->
                StringAddCalculator.add(command) shouldBe expected
            }
        }

        context("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.") {
            withData(
                nameFn = { "add(\"${it.command}\") =  ${it.expected}" },
                CommandExpected("//;\n1;2;3", 6),
                CommandExpected("//;\n2;3;5", 10),
                CommandExpected("//;\n3;5;6;11", 25),
            ) { (command, expected) ->
                StringAddCalculator.add(command) shouldBe expected
            }
        }

        context("문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다.") {
            withData(
                nameFn = { "add(\"${it}\") throw RuntimeException" },
                listOf("-2:3,5", "//;\n2;3;-5", "//;\n3;5;-6;11")
            ) { negativeCmd ->
                shouldThrow<RuntimeException> {
                    StringAddCalculator.add(negativeCmd)
                }
            }
        }
    }
})