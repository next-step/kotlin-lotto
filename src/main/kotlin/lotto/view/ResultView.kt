package lotto.view

import Lotto

class ResultView {

    fun printCount(type: ResultType, count: Int) {
        println(type.message.format(count))
    }

    fun printLottoList(lottoList: List<Lotto>) {
        lottoList.forEach {
            println(it.numbers)
        }
    }

    fun printResult(amount: Int, lottoList: List<Lotto>) {
        println(INIT_RESULT)
        var totalMoney = 0
        val lottoByRank = lottoList.groupBy { it.rank }
        LottoResult.values().forEach { lottoResult ->
            val lottoSize = lottoByRank[lottoResult.rank]?.size ?: 0
            totalMoney +=  matchResult(lottoResult, lottoSize)
        }
        println(ResultType.PROFIT_RATE.message.format(totalMoney.toDouble() / amount))
    }

    private fun matchResult(lottoResult: LottoResult, size: Int): Int {
        println(lottoResult.message.format(size))
        return lottoResult.rank.getWinningMoney(size)
    }

    companion object {
        private const val INIT_RESULT = "\n당첨 통계\n---------"
    }
}
