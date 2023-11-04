package lotto

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoVendingMachineTest : BehaviorSpec({

    Given("구입 금액을 넣으면") {
        val input = 14000
        When("로또 자판기는") {
            val lottos = LottoVendingMachine.generate(input)
            Then("금액에 맞는 로또를 자동으로 생성한다.") {
                lottos.size shouldBe 14
            }
        }
    }
})
