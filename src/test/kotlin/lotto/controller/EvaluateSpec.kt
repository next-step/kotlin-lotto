package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class EvaluateSpec: BehaviorSpec({
    given("로또 구매가 완료되었을 때") {
        val lottoController = LottoController()
        lottoController.tickets = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(listOf(7, 8, 9, 10, 11, 12))
        )

        `when`("우승자 번호와 보너스 볼로 평가 요청을 보냈을 때") {
            val evaluateRequest = EvaluateRequest.from("1, 2, 3, 4, 5, 6", "7")

            then("매칭 결과에 따라 Prize 획득 별로 집계된다.") {
                val lottoResult = lottoController.evaluate(evaluateRequest)
                lottoResult.rankCounts[Rank.FIRST] shouldBe 1
                lottoResult.rankCounts[Rank.MISS] shouldBe 1
            }
        }
    }
})