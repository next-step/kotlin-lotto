package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec

class EvaluateResponseSpec : BehaviorSpec({
    given("로또 구매가 완료되었을 때") {
        val lottoController = LottoController()
        lottoController.tickets = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket(listOf(7, 8, 9, 10, 11, 12))
        )

        `when`("우승자 번호와 보너스 볼로 평가 요청을 보냈을 때") {
            val evaluateRequest = EvaluateRequest.from("1, 2, 3, 4, 15, 16", "7")

            then("Prize 획득 횟수를 정리해서 보여준다.") {
                val lottoResult = lottoController.evaluate(evaluateRequest)
                val evaluateResponse = EvaluateResponse.from(lottoResult)

                println(evaluateResponse.rankResult)
                println(evaluateResponse.earningRate.toInt())
            }
        }
    }
})

class EvaluateResponse(
    val rankResult: Map<Int, Pair<Int, Int>>,
    val earningRate: Double,
) {
    companion object {
        fun from(lottoResult: LottoResult): EvaluateResponse {
            val rankResult = lottoResult.rankCounts
                .map { (rank, count) -> rank.countOfMatch to Pair(rank.winningMoney, count)  }
                .toMap()

            val earningRate = lottoResult.getEarningRate()
            return EvaluateResponse(rankResult, earningRate)
        }
    }
}

