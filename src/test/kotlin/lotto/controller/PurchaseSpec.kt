package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.presentation.controller.LottoController
import lotto.presentation.controller.dto.PurchaseRequest

class PurchaseSpec : BehaviorSpec({
    given("구입 금액이 주어졌을 때") {
        val inputAmount = 2000
        val purchaseRequest = PurchaseRequest.from(inputAmount)
        val lottoController = LottoController()

        `when`("로또를 구입 금액 만큼 구매 요청한다.") {
            val purchaseResponse = lottoController.purchase(purchaseRequest)

            then("구입 금액에 맞는 갯수의 로또 티켓이 생성된다.") {
                purchaseResponse.tickets.size shouldBe 2
            }
        }
    }
})
