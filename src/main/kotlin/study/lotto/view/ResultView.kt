package study.lotto.view

import study.lotto.model.LottoPrize
import study.lotto.model.Lotto
import study.lotto.model.LottoStat

/**
 * @author 이상준
 */
class ResultView {
    fun printLotto(result: List<Lotto>) {
        result.forEach {
            println(it.lottoNumbers)
        }
    }

    fun printLottoCount(result: List<Lotto>) {
        println("${result.size}개를 구매했습니다.")
    }

    fun printWinLotto(statSet: Set<LottoStat>) {
        println("당첨 통계")
        println("---------")
        statSet.forEach {
            println("${it.lottoPrize.prize}개 일치 (${it.lottoPrize.amount})원 - ${it.count}개")
        }
    }

    fun printProfit(lottoProfit: Double) {
        println("총 수익률은 $lottoProfit% 입니다.")
    }
}
