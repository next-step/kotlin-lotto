package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain

class LottoVendingMachineTest : BehaviorSpec({

    Given("구입 금액을 넣으면") {
        val input = 14000
        When("로또 자판기는") {
            val lottoVendingMachine = LottoVendingMachine(object : LottoGenerator {
                override fun generate(): Lotto {
                    return Lotto(1, 2, 3, 4, 5, 6)
                }
            })
            val lottos = lottoVendingMachine.generate(input)
            Then("금액에 맞는 로또를 자동으로 생성한다.") {
                lottos.shouldContain(Lotto(1, 2, 3, 4, 5, 6))
            }
        }
    }
})
