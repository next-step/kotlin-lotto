package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoVendingMachineTest : BehaviorSpec({
    given("로또 구매 금액을 입력하면") {
        `when`("구매한 금액의 만큼의") {
            val money = PurchaseAmount(14000.00)

            then("로또가 발급된다.") {
                LottoVendingMachine.buy(money).size shouldBe money.amount / 1000.00
            }
        }
    }
})
