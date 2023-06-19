package calculator.expression

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class NumberParserTest : BehaviorSpec({

    Given("null 값을 입력으로 받은 경우") {
        val input: String? = null
        When("NumberParser 를 생성할 때") {
            val numberParser = NumberParser.of(input, ",")
            Then("결과는 [0] 이어야 한다") {
                numberParser.numbers shouldBe listOf(0)
            }
        }
    }

    Given("빈 문자열을 입력으로 받은 경우") {
        val input = ""
        When("NumberParser 를 생성할 때") {
            val numberParser = NumberParser.of(input, ",")
            Then("결과는 [0] 이어야 한다") {
                numberParser.numbers shouldBe listOf(0)
            }
        }
    }

    Given("한 개의 숫자를 입력으로 받은 경우") {
        val input = "5"
        When("NumberParser 를 생성할 때") {
            val numberParser = NumberParser.of(input, ",")
            Then("결과는 [5] 이어야 한다") {
                numberParser.numbers shouldBe listOf(5)
            }
        }
    }
    Given("음수를 입력으로 받은 경우") {
        val input = "-1"
        When("NumberParser 를 생성할 때") {
            Then("RuntimeException 이 발생해야 한다") {
                shouldThrow<RuntimeException> {
                    NumberParser.of(input, ",")
                }
            }
        }
    }
    Given("기본 구분자를 사용한 문자열을 입력받을 경우 ") {
        val input = "1,2,3"
        When("NumberParser 를 생성할 때") {
            val numberParser = NumberParser.of(input, ",")
            Then("결과는 [1, 2, 3] 이어야 한다") {
                numberParser.numbers shouldBe listOf(1, 2, 3)
            }
        }
    }
    Given("잘못된 형식의 문자열을 입력으로 받은 경우") {
        val input = "a,2,3"
        When("NumberParser 를 생성할 때") {
            Then("RuntimeException 이 발생해야 한다") {
                shouldThrow<RuntimeException> {
                    NumberParser.of(input, ",")
                }
            }
        }
    }
})
