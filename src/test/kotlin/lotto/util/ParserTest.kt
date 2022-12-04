package lotto.util

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.util.Parser.LOTTO_NUMBER_SIZE_ERROR

internal class ParserTest : BehaviorSpec({
    Given("정상적인 입력이 들어온다면, ") {
        When("중복된 숫자를 포함한다면 ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Parser.parse("1, 2, 3, 4, 6, 6")
                }
                exception.message shouldBe LOTTO_NUMBER_SIZE_ERROR
            }
        }

        When("숫자가 6개가 아니라면 ") {
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Parser.parse("1, 2, 3, 4, 5, 6, 7")
                }
                exception.message shouldBe LOTTO_NUMBER_SIZE_ERROR
            }

            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    Parser.parse("1, 2, 3, 4, 5")
                }
                exception.message shouldBe LOTTO_NUMBER_SIZE_ERROR
            }
        }

        When("로또 티켓의 파싱을 진행할 때, ") {
            val rawString = "[1, 2, 3, 4, 5, 6]"
            val result = Parser.parse(rawString)
            Then("성공한다.") {
                result shouldBe listOf(1, 2, 3, 4, 5, 6)
            }
        }

        When("당첨 로또 티켓의 파싱을 진행할 때, ") {
            val rawString = "1, 2, 3, 4, 5, 6"
            val result = Parser.parse(rawString)
            Then("성공한다.") {
                result shouldBe listOf(1, 2, 3, 4, 5, 6)
            }
        }
    }
})
