package lotto.view

import lotto.Lotto
import lotto.LottoResult
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

    fun printResult(amount: Int, lottoList: List<LottoResult?>, totalWinningMoney: Int) {
        println(INIT_RESULT)
        lottoList.forEach {
            it?.let {
                println(it.matchResult.message.format(it.count))
            }
        }
        println(ResultType.PROFIT_RATE.message.format(totalWinningMoney.toDouble() / amount))
    }

    companion object {
        private const val INIT_RESULT = "\n당첨 통계\n---------"
    }
}
