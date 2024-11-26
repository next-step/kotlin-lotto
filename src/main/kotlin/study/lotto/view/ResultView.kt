package study.lotto.view

import study.lotto.model.Lotto
import study.lotto.model.LottoStat
import study.lotto.model.Rank

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
        statSet.filter {
            it.lottoPrize != Rank.MISS
        }.forEach {
            val bonusMessage = if (it.lottoPrize == Rank.SECOND) BONUS_MATCH_MESSAGE else " "
            println("${it.lottoPrize.prize}개 일치${bonusMessage}(${it.lottoPrize.amount})원 - ${it.count}개")
        }
    }

    fun printProfit(lottoProfit: Double) {
        println("총 수익률은 $lottoProfit% 입니다.")
    }

    companion object {
        const val BONUS_MATCH_MESSAGE = ", 보너스 볼 일치"
        const val WINNER_STAT_MESSAGE = "당첨 통계"
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
    }
}
