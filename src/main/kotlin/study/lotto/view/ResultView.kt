package study.lotto.view

import study.lotto.model.LottoStats
import study.lotto.model.Lottos
import study.lotto.model.Rank

/**
 * @author 이상준
 */
class ResultView {
    fun printLotto(lottos: Lottos) {
        lottos.getLottos().forEach {
            println(it.lottoNumbers.joinToString(prefix = "[", postfix = "]") { lottoNumber -> lottoNumber.number.toString() })
        }
    }

    fun printLottoCount(
        manualCount: Int,
        autoCount: Int,
    ) {
        println(PURCHASE_MESSAGE.format(manualCount, autoCount))
    }

    fun printWinLotto(lottoStats: LottoStats) {
        println(WINNER_STAT_MESSAGE)
        println("---------")
        lottoStats.getStat().filter {
            it.rank != Rank.MISS
        }.forEach {
            val bonusMessage = if (it.rank == Rank.SECOND) BONUS_MATCH_MESSAGE else " "
            println(WINNER_STAT_RESULT_MESSAGE.format(it.rank.countOfMatch, bonusMessage, it.rank.amount, it.count))
        }
    }

    fun printProfit(lottoProfit: Double) {
        println(PROFIT_MESSAGE.format(lottoProfit))
    }

    companion object {
        private const val BONUS_MATCH_MESSAGE = ", 보너스 볼 일치"
        private const val WINNER_STAT_MESSAGE = "당첨 통계"
        private const val WINNER_STAT_RESULT_MESSAGE = "%s 개 일치 %s(%s) - %s개"
        private const val PURCHASE_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다."
        private const val PROFIT_MESSAGE = "총 수익률은 %s%% 입니다."
    }
}
