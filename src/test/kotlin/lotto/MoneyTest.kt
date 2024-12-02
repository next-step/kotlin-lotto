package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MoneyTest : BehaviorSpec({

    Given("Money에") {
        When("Money가 음수이면") {
            Then("IllegalArgumentException을 던진다") {
                shouldThrow<IllegalArgumentException> {
                    Money(-1)
                }.message shouldBe "음수는 입력할 수 없습니다."
            }
        }
    }

    Given("Money 2에") {
        When("Money 1을 빼면") {
            Then("Money가 1 감소한다") {
                val left = Money(2)
                val right = Money(1)
                val result = left - right
                result shouldBe Money(1)
            }
        }
    }
})
