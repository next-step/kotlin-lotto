package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("1. 로또는") {
        When("생성시") {
            val lotto = Lotto()
            Then("6개의 1에서 45까지의 숫자를 가져간다.") {
                lotto.numbers.size shouldBe 6
                lotto.numbers.all { it in 1..45 } shouldBe true
            }
        }
    }
})
