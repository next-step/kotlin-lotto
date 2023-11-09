package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class LottoVendingMachineTest : BehaviorSpec({

    Given("구입 금액과 수동으로 구매한 로또 수를 넣으면") {
        val input = 14000
        val manualLottoCount = 3
        When("로또 자판기는") {
            val lottoVendingMachine = LottoVendingMachine(object : LottoGenerator {
                override fun generate(): Lotto {
                    return Lotto(1, 2, 3, 4, 5, 6)
                }
            })
            val lottos = lottoVendingMachine.generate(input, manualLottoCount)
            Then("수동으로 구매한 후 남은 금액으로 자동 로또를 발급한다.") {
                lottos.lottos.count() shouldBe 11
                lottos.lottos.shouldContain(Lotto(1, 2, 3, 4, 5, 6))
            }
        }
    }
})
