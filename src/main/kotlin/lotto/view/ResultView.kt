package lotto.view

import lotto.model.Coincidence
import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.Lottos

object ResultView {
    fun printMyLottos(lottos: Lottos) {
        lottos.myLottos.forEach { println(it.toString()) }
        println()
    }

    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printResult(myLottos: Lottos, winningLotto: Lotto, bonusLottoNumber: LottoNumber) {
        printStatisticsInstruction()
        printResultStatistics(myLottos, winningLotto, bonusLottoNumber)
        printEarningRate(myLottos, winningLotto)
    }

    fun printResultStatistics(myLottos: Lottos, winningLotto: Lotto, bonusLottoNumber: LottoNumber) {
        Coincidence.values().forEach {
            print("${it.coincidenceCount}개 일치")
            if (it.hasBonusNum) print(" 보너스 볼 일치")
            print("(${it.prizeMoney}원)")
            println("- ${myLottos.getCoincidenceCount(it, winningLotto, bonusLottoNumber)}개 ")
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
