package lotto.view

import lotto.domain.model.Lotto
import lotto.domain.model.LottoResult
import lotto.domain.model.ProfitState

object ResultView {
    fun printBuyResult(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다")
        lottos.forEach {
            println(it.numbers.sorted())
        }
        println()
    }

    fun printLottoResult(results: List<LottoResult>, earningRate: Double, profitState: ProfitState) {
        println("\n당첨 통계")
        println("---------")
        results.filter { it.prize.reward > 0 }.forEach {
            println("${it.prize.matches}개 일치 (${it.prize.reward}원) - ${it.count}개")
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
}
