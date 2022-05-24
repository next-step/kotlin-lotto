package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.next
import io.kotest.property.checkAll

class LottoStoreTest : BehaviorSpec({
    Given("로또 판매점에서") {
        When("충분한 돈으로") {
            val numberOfTicket = Arb.int(1..100).next()
            val changes = Arb.int(0..999).next()
            val money = (numberOfTicket * LottoStore.PRICE_OF_ONE_LOTTO_TICKET) + changes

            And("로또 티켓을 구매하면") {
                val expected = money / LottoStore.PRICE_OF_ONE_LOTTO_TICKET
                Then("로또 티켓은 1000원에 1개로 받는다 (금액: $money, 개수: $expected)") {
                    val lottoTickets = LottoStore.buy(money)

                    lottoTickets.shouldHaveSize(expected)
                }
            }

            And("로또 티켓을 100개 넘개 구매하면") {
                Then("IllegalArgumentException 예외 발생") {
                    shouldThrowExactly<IllegalArgumentException> {
                        LottoStore.buy(
                            LottoStore.PRICE_OF_ONE_LOTTO_TICKET * LottoStore.MAXIMUM_SIZE_OF_TICKET + 1
                        )
                    }
                }
            }
        }

        When("충분하지 못한 돈으로") {
            And("로또 티켓을 구매하면") {
                Then("IllegalArgumentException 예외 발생") {
                    checkAll(Arb.int(0..999)) { money ->
                        shouldThrowExactly<IllegalArgumentException> {
                            LottoStore.buy(money)
                        }
                    }
                }
            }
        }
    }
})
