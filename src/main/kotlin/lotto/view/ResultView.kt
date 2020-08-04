package lotto.view

import lotto.domain.Lotto

object ResultView {
    private const val BUY_COUNT_SURFIX = "개를 구매했습니다."

    fun printBuyCount(buyCount: Int, lottos: List<Lotto>) {
        println("${buyCount}$BUY_COUNT_SURFIX")
        printJoinToString(lottos)
    }

    fun printResult(
        result: List<ResultLotto>
    ) {
        println("당첨 통계")
        println("---------")
        printJoinToString(result)
    }

    fun printTotalRate(totalRate: Double) {
        println("총 수익률은 ${totalRate}입니다.")
    }

    private fun printJoinToString(lottos: List<Any>) {
        println(lottos.joinToString(""))
    }
}
