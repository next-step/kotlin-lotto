package autolotto.view

import autolotto.calculator.LottoCalculator
import autolotto.entity.Lotto

object OutPutView {
    private val FOUR_PRIZE_MONEY = 5000
    private val THREE_PRIZE_MONEY = 50000
    private val SECOND_PRIZE_MONEY = 1500000
    private val FIRST_PRIZE_MONEY = 2000000000

    fun printLottoInfo(lottos: List<Lotto>) {
        repeat(lottos.size) {
            printLotto(lottos[it])
        }
    }

    fun printLotto(lotto: Lotto) {
        for (number in lotto.lottoGame) {
            print("$number ")
        }
        println()
    }

    fun printLottoResults(
        lottos: Map<Int, Int>,
        amount: Int,
    ) {
        println("당첨 통계")
        println("---------")
        printLottoResult(lottos)
        printLottoProfitRate(lottos, amount)
    }

    private fun printLottoProfitRate(
        lotto: Map<Int, Int>,
        amount: Int,
    ) {
        val totalPrize: Int = LottoCalculator.getTotalPrize(lotto)
        val profitRate = LottoCalculator.getProfitRate(totalPrize, amount)
        println("총 수익률은 ${profitRate}입니다.${if (profitRate < 1) "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" else ""}")
    }


    private fun printLottoResult(lotto: Map<Int, Int>) {
        lotto.forEach() { (number, count) -> printLottoPrizeRank(number, count) }
    }

    private fun printLottoPrizeRank(
        number: Int,
        count: Int
    ) {
        when (number) {
            3 -> println("${number}개 일치 (${FOUR_PRIZE_MONEY}원) - ${count}개")
            4 -> println("${number}개 일치 (${THREE_PRIZE_MONEY}원) - ${count}개")
            5 -> println("${number}개 일치 (${SECOND_PRIZE_MONEY}원) - ${count}개")
            6 -> println("$number 개 일치 (${FIRST_PRIZE_MONEY}원) - ${count}개")
        }
    }

}
