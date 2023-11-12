package lotto.view

import Lotto

class ResultView {

    fun printCount(type: ResultType, count: Int) {
        println(type.message.format(count))
    }

    fun printResult(amount: Int, lottoList: List<Lotto>) {
        println(INIT_RESULT)
        var totalMoney = 0
        val lottoByMatch = lottoList.groupBy { it.matchCount }
        lottoByMatch.forEach { (matchCount, lottoList) ->
            LottoResult.findByMatchCount(matchCount)?.let {
                totalMoney += matchResult(it, lottoList.size)
            }
        }
        println(ResultType.PROFIT_RATE.message.format(totalMoney.toDouble() / amount))
    }

    private fun matchResult(lottoResult: LottoResult, size: Int): Int {
        println(lottoResult.message.format(size))
        return lottoResult.winningMoney * size
    }

    companion object {
        private const val INIT_RESULT = "\n당첨 통계\n---------"
    }
}
