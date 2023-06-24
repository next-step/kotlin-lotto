package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import lotto.test.FakeGenerator

class LottoPurchaseMachineTest : BehaviorSpec({
    given("10000원을 전달한다.") {
        val paidPrice = 10000

        `when`("2개의 수동 로또를 전달한다.") {
            val manualLotto1 = FakeGenerator.lottoNumbers(1, 2, 3, 4, 5, 6)
            val manualLotto2 = FakeGenerator.lottoNumbers(11, 12, 13, 14, 15, 16)
            val manualLottos = listOf(manualLotto1, manualLotto2)
            val purchaseInfo = PurchaseInfo(paidPrice, manualLottos)

            then("2개의 수동 로또와 8개의 자동 로또를 생성한다.") {
                val lottos = LottoPurchaseMachine.getLottos(purchaseInfo)

                lottos.size shouldBe 10
                lottos shouldContain Lotto(manualLotto1)
                lottos shouldContain Lotto(manualLotto2)

            }
        }
    }

})
