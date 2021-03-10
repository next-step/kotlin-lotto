package lotto.view

import lotto.model.Coincidence
import lotto.model.Lottos
import lotto.model.WinningLotto

object ResultView {
    fun printMyLottos(lottos: Lottos) {
        lottos.lottos.forEach { println(it.toString()) }
        println()
    }

    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printResult(myLottos: Lottos, winningLotto: WinningLotto) {
        printStatisticsInstruction()
        printResultStatistics(myLottos, winningLotto)
        printEarningRate(myLottos, winningLotto)
    }

    fun printResultStatistics(myLottos: Lottos, winningLotto: WinningLotto) {
        Coincidence.values().forEach {
            print("${it.coincidenceCount}개 일치")
            if (it.hasBonusNum) print(" 보너스 볼 일치")
            print("(${it.prizeMoney}원)")
            println("- ${it.getMatchedCount(myLottos, winningLotto)}개 ")
        }
    }

    fun printEarningRate(myLottos: Lottos, winningLotto: WinningLotto) {
        val earningRate = myLottos.getEarningRate(winningLotto.winningLotto)
        println("총 수익률은 $earningRate")
    }

    private fun printStatisticsInstruction() {
        println("당첨 통계")
        println("==============")
    }
}
