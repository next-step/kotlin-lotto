package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPurchaseMachineTest : StringSpec({
    "지불한 금액만큼 로또를 리턴한다." {
        listOf(
            14000 to 14,
            14500 to 14,
            0 to 0,
            -1 to 0,
        ).forEach { (purchasePrice, lottosSize) ->
            LottoPurchaseMachine.getLottos(purchasePrice).size shouldBe lottosSize
        }
    }
})
