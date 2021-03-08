package lotto.view

import lotto.model.Coincidence
import lotto.model.Lotto
import lotto.model.Lottos

object ResultView {
    fun printMyLottos(lottos: Lottos) {
        lottos.lottos.forEach { println(it.lottoNums.toString()) }
        println()
    }

    fun printLottoCount(lottoCount: Int) {
        println("${lottoCount}개를 구매했습니다.")
    }

    fun printResultStatistics(myLottos: Lottos, winningLotto: Lotto) {
        Coincidence.values().forEach {
            val count = myLottos.check(winningLotto.lottoNums.map { it.number }, it.coincidenceCount)
            println("${it.coincidenceCount}개 일치 (${it.prizeMoney}원) - ${count}개 ")
        }
    }

    fun printEarningRate(myLottos: Lottos, winningLotto: Lotto) {
        val earningRate = myLottos.getEarningRate(winningLotto.lottoNums.map { it.number })
        println("총 수익률은 $earningRate")
    }
}
