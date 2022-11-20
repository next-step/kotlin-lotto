package lotto.util

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class ParserTest : BehaviorSpec({
    Given("정상적인 입력이 들어온다면, ") {
        When("로또 티켓의 파싱을 진행할 때, ") {
            val rawString = "[1, 2, 3]"
            val result = Parser.parse(rawString)
            Then("성공한다.") {
                result shouldBe listOf(1, 2, 3)
            }
        }

        When("당첨 로또 티켓의 파싱을 진행할 때, ") {
            val rawString = "1, 2, 3"
            val result = Parser.parse(rawString)
            Then("성공한다.") {
                result shouldBe listOf(1, 2, 3)
            }
        }
    }
})
