package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PriceTest : BehaviorSpec({

    Given("Price에") {
        val price = Price(14_000)

        When("Price가 14,000원일 때") {
            Then("isMoreThan(13,000)은 true를 반환한다") {
                price.isMoreThan(13_000) shouldBe true
            }

            Then("isMoreThan(15,000)은 false를 반환한다") {
                price.isMoreThan(15_000) shouldBe false
            }

            Then("subtract(13,000)은 1,000원을 반환한다") {
                price.subtract(13_000).value shouldBe 1_000
            }

            Then("subtract(14,000)은 0원을 반환한다") {
                price.subtract(14_000).value shouldBe 0
            }
        }

        When("Price가 0원일 때") {
            val zeroPrice = Price(0)

            Then("isMoreThan(0)은 true를 반환한다") {
                zeroPrice.isMoreThan(0) shouldBe true
            }

            Then("isMoreThan(1)은 false를 반환한다") {
                zeroPrice.isMoreThan(1) shouldBe false
            }

            Then("subtract(0)은 0원을 반환한다") {
                zeroPrice.subtract(0).value shouldBe 0
            }

            Then("subtract(1)은 IllegalArgumentException을 던진다") {
                shouldThrow<IllegalArgumentException> {
                    zeroPrice.subtract(1)
                }.message shouldBe "잔액이 부족합니다. 현재 금액 = 0, 구매 금액 = 1"
            }
        }

        When("Price가 음수이면") {
            Then("IllegalArgumentException을 던진다") {
                shouldThrow<IllegalArgumentException> {
                    Price(-1)
                }.message shouldBe "음수는 입력할 수 없습니다."
            }
        }
    }
})
