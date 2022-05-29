package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll

class LottoStoreTest : BehaviorSpec({
    Given("로또 판매점에서") {
        When("1000원 이상의 돈으로") {
            val money = PurchaseMoney(34_567)
            val expectedTickets = 34

            And("로또 티켓을 구매하면") {
                Then("로또 티켓은 1000원에 1개로 받는다 (금액: $money, 개수: $expectedTickets)") {
                    LottoStore.buy(money) shouldHaveSize expectedTickets
                }
            }

            And("로또 티켓을 100개 넘개 구매하면") {
                Then("IllegalArgumentException 예외 발생") {
                    shouldThrowExactly<IllegalArgumentException> {
                        LottoStore.buy(101_000.toPurchaseMoney())
                    }
                }
            }
        }

        When("1000원 이하의 돈으로") {
            And("로또 티켓을 구매하면") {
                Then("IllegalArgumentException 예외 발생") {
                    checkAll(Arb.int(0..999)) { money ->
                        shouldThrowExactly<IllegalArgumentException> {
                            LottoStore.buy(money.toPurchaseMoney())
                        }
                    }
                }
            }
        }
    }
})
