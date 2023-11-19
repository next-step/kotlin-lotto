package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import lotto.domain.LottoNumber
import lotto.domain.LottoTickets
import lotto.presentation.controller.EvaluateRequest
import lotto.presentation.controller.LottoController

class EvaluateResponseSpec : BehaviorSpec({
    given("로또 구매가 완료되었을 때") {
        val lottoController = LottoController()
        lottoController.tickets = listOf(
            LottoNumber.of(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumber.of(listOf(7, 8, 9, 10, 11, 12))
        ).let(::LottoTickets)

        `when`("우승자 번호와 보너스 볼로 평가 요청을 보냈을 때") {
            val evaluateRequest = EvaluateRequest.from("1, 2, 3, 4, 15, 16", "7")

            then("Prize 획득 횟수를 정리해서 보여준다.") {
                val evaluateResponse = lottoController.evaluate(evaluateRequest)

                println(evaluateResponse.rankResult)
                println(evaluateResponse.earningRate.toInt())
            }
        }
    }
})
