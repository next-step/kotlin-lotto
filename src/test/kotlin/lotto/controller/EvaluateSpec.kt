package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.presentation.controller.LottoController
import lotto.presentation.controller.dto.EvaluateRequest
import lotto.presentation.controller.dto.PurchaseResponse

class EvaluateSpec : BehaviorSpec({
    given("로또 구매가 완료되었을 때") {
        val lottoController = LottoController()
        val tickets = listOf(
            LottoTicket.of(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.of(listOf(7, 8, 9, 10, 11, 12))
        ).let(::LottoTickets)
        val winningTicket = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val purchaseResponse = PurchaseResponse.of(tickets)

        `when`("우승자 번호와 보너스 볼로 평가 요청을 보냈을 때") {
            val evaluateRequest = EvaluateRequest.from(winningTicket, bonusNumber)

            then("각 로또 티켓의 등수를 평가해서 보여준다.") {
                val evaluateResponse = lottoController.evaluate(purchaseResponse, evaluateRequest)

                evaluateResponse.rankResult[0][2] shouldBe 1
                evaluateResponse.earningRate shouldBe 1_000_000.0
            }
        }
    }
})
