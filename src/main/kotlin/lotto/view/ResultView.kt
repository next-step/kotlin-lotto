package lotto.view

import lotto.model.Coincidence
import lotto.model.Lotto
import lotto.model.Lottos

object ResultView {
    fun printMyLottos(lottos: Lottos) {
        lottos.myLottos.forEach { println(it.lottoNums.toString()) }
        println()
    }

    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printResult(myLottos: Lottos, winningLotto: Lotto) {
        printStatisticsInstruction()
        printResultStatistics(myLottos, winningLotto)
        printEarningRate(myLottos, winningLotto)
    }

    fun printResultStatistics(myLottos: Lottos, winningLotto: Lotto) {
        Coincidence.values().forEach {
            println("${it.coincidenceCount}개 일치 (${it.prizeMoney}원) - ${it.getMatchCount(myLottos, winningLotto)}개 ")
        }
    }

    fun printEarningRate(myLottos: Lottos, winningLotto: Lotto) {
        val earningRate = myLottos.getEarningRate(winningLotto)
        println("총 수익률은 $earningRate")
    }

    private fun printStatisticsInstruction() {
        println("당첨 통계")
        println("==============")
    }
}
