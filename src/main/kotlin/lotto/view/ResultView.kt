package lotto.view

import lotto.Lotto
import lotto.Rank
import lotto.view.ResultType.PURCHASE_COUNT

class ResultView {

    fun printCount(count: Int) {
        println(PURCHASE_COUNT.message.format(count))
    }

    fun printLottoList(lottoList: List<Lotto>) {
        lottoList.forEach {
            println(it.numbers)
        }
    }

    fun printResult(amount: Int, result: Map<Rank, Int>, totalWinningMoney: Int) {
        println(INIT_RESULT)
        LottoMatchResult.values().forEach {
            println(it.message.format(result[it.rank] ?: 0))
        }
        println(ResultType.PROFIT_RATE.message.format(totalWinningMoney.toDouble() / amount))
    }

    companion object {
        private const val INIT_RESULT = "\n당첨 통계\n---------"
    }
}
