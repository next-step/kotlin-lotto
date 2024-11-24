package study.lotto.view

import study.lotto.model.LottePrize
import study.lotto.model.Lotto

/**
 * @author 이상준
 */
class ResultView {
    fun printLotte(result: List<Lotto>) {
        result.forEach {
            println(it.lotteNumbers)
        }
    }

    fun printLotteCount(result: List<Lotto>) {
        println("${result.size}개를 구매했습니다.")
    }

    fun printWinLotte(statMap: Map<LottePrize, Int>) {
        println("당첨 통계")
        println("---------")
        statMap.forEach {
            println("${it.key.prize}개 일치 (${it.key.amount})원 - ${it.value}개")
        }
    }

    fun printProfit(lottoProfit: Double) {
        println("총 수익률은 $lottoProfit% 입니다.")
    }
}
