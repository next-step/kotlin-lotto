package lotto2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoMoneyTest : BehaviorSpec({

    lateinit var lottoMoney: LottoMoney

    Given("잔액이 만원이 주어질 때") {

        beforeEach {
            lottoMoney = LottoMoney(10_000)
        }

        When("5천원을 차감할 경우") {
            Then("잔액은 5천원이므로 구매할 수 있는 로또티켓 수량은 5개이다.") {
                lottoMoney.subtract(5_000)

                lottoMoney.toPurchasableTicketQuantity() shouldBe 5
            }
        }

        When("7천원을 차감할 경우") {
            Then("잔액은 3천원이므로 구매할 수 있는 로또티켓 수량은 3개이다.") {
                lottoMoney.subtract(7_000)

                lottoMoney.toPurchasableTicketQuantity() shouldBe 3
            }
        }

        When("만원을 차감할 경우") {
            Then("잔액은 0원이므로 구매할 수 있는 로또티켓은 없다.") {
                lottoMoney.subtract(10_000)

                lottoMoney.toPurchasableTicketQuantity() shouldBe 0
            }
        }

        When("2만원을 차감할 경우") {
            Then("잔액이 부족하여 예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    lottoMoney.subtract(20_000)
                }
            }
        }
    }
})
