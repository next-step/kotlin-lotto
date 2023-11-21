package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.presentation.controller.LottoController
import lotto.presentation.controller.dto.PurchaseRequest

class PurchaseSpec : BehaviorSpec({
    given("구입 금액이 주어졌을 때") {
        val inputAmount = "2000"
        val purchaseRequest = PurchaseRequest.from(inputAmount)
        val lottoController = LottoController()

        `when`("로또를 구입 금액 만큼 구매 요청한다.") {
            lottoController.purchase(purchaseRequest)

            then("구입 금액에 맞는 로또 티켓이 생성된다.") {
                val purchasedTickets = lottoController.tickets ?: throw IllegalArgumentException("티켓이 저장되지 않았습니다")
                purchasedTickets.size() shouldBe 2
            }
        }
    }
})
