package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.presentation.controller.dto.EvaluateRequest
import lotto.presentation.controller.LottoController

class EvaluateSpec : BehaviorSpec({
    given("로또 구매가 완료되었을 때") {
        val lottoController = LottoController()
        lottoController.tickets = listOf(
            LottoTicket.of(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.of(listOf(7, 8, 9, 10, 11, 12))
        ).let(::LottoTickets)

        `when`("우승자 번호와 보너스 볼로 평가 요청을 보냈을 때") {
            val evaluateRequest = EvaluateRequest.from("1, 2, 3, 4, 5, 6", "7")

            then("매칭 결과에 따라 Prize 획득 별로 집계된다.") {
                val evaluateResp = lottoController.evaluate(evaluateRequest)
                evaluateResp.rankResult[0][0] shouldBe 6
                evaluateResp.rankResult[0][1] shouldBe 2_000_000_000
                evaluateResp.rankResult[0][2] shouldBe 1
            }
        }
    }
})
