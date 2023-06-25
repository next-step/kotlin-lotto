package lotto.view

import lotto.domain.model.LottoResult
import lotto.domain.model.Lottos
import lotto.domain.model.Prize
import lotto.domain.model.ProfitState

object ResultView {
    fun printBuyResult(lottos: Lottos) {
        println("${lottos.items.size}개를 구매했습니다")
        lottos.items.forEach {
            println(it.numbers.sortedBy { number -> number.value })
        }
        println()
    }

    fun printLottoResult(results: List<LottoResult>, earningRate: Double, profitState: ProfitState) {
        println("\n당첨 통계")
        println("---------")
        results.filter { it.prize.reward.value > 0 }.forEach {
            println("${it.prize.toText()} - ${it.count}개")
        }
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 ${profitState.toText()}라는 의미임)")
    }

    fun printMessage(message: String) = println(message)

    private fun ProfitState.toText(): String {
        return when (this) {
            ProfitState.PROFIT -> "이익이"
            ProfitState.SAME -> "본전이"
            ProfitState.LOSS -> "손해"
        }
    }

    private fun Prize.toText(): String {
        return when (this) {
            Prize.SIX_MATCH -> "6개 일치 (${reward}원)"
            Prize.FIVE_MATCH_PLUS_BONUS -> "5개 일치, 보너스 볼 일치 (${reward}원)"
            Prize.FIVE_MATCH -> "5개 일치 (${reward}원)"
            Prize.FOUR_MATCH -> "4개 일치 (${reward}원)"
            Prize.THREE_MATCH -> "3개 일치 (${reward}원)"
            else -> ""
        }
    }
}
