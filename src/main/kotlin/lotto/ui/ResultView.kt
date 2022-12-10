package lotto.ui

import lotto.domain.LottoDispenser
import lotto.domain.LottoStatics
import lotto.domain.model.Lotto

class ResultView {

    fun showPurchaseResult(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach { println(it) }
    }

    fun showResult(dispenser: LottoDispenser) {
        dispenser.checkWinningLottoList()

        println("\n당첨 통계")
        println("---------")

        val statics = LottoStatics(dispenser.ranks)
        val earningRate = statics.calculateEarningRate(statics.totalReward, dispenser.amount)
        val winningResult = statics.winningResult

        println("3개 일치 (5000원)- ${winningResult.numberOfFifthGrade}개")
        println("4개 일치 (50000원)- ${winningResult.numberOfFourthGrade}개")
        println("5개 일치 (1500000원)- ${winningResult.numberOfThirdGrade}개")
        println("5개 일치, 보너스 볼 일치(30000000원) - ${winningResult.numberOfSecondGrade}개")
        println("6개 일치 (2000000000원)- ${winningResult.numberOfFirstGrade}개")
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
