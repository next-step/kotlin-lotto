package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PriceTest : BehaviorSpec({

    Given("Price에") {
        When("Price가 음수이면") {
            Then("IllegalArgumentException을 던진다") {
                shouldThrow<IllegalArgumentException> {
                    Money(-1)
                }.message shouldBe "음수는 입력할 수 없습니다."
            }
        }
    }
})
