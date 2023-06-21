package lotto.view

import lotto.LottoDrawingMachine
import lotto.Lottos

object ResultView {
    fun printPurchasedLottos(lottos: Lottos) {
        println("${lottos.size} 개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }

    fun printDrawResult(drawResult: LottoDrawingMachine.DrawResult) {
        println("당첨 통계")
        println("---------")
        drawResult.rankPrizes.forEach {
            println("${it.matchCount}개 일치 (${it.reward}원)- ${it.winnerCount}개")
        }
        println("총 수익률은 ${drawResult.totalRoi}입니다.")
    }
}
