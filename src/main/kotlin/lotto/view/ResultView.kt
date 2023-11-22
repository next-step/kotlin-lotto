package lotto.view

import lotto.domain.Money
import lotto.domain.WinningResult

object ResultView {
    fun print(winningResult: WinningResult, spentMoney: Money) {
        println()
        println("당첨 통계")
        println("---------")
        winningResult.result().forEach {
            println("${it.key.needToBeMatched}개 일치 (${it.key.award.amount}원)- ${it.value}개")
        }
        println("총 수익률은 ${"%.2f".format(winningResult.rateOfReturn(spentMoney))}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
