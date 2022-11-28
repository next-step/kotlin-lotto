package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoStatics
import lotto.domain.Winner
import lotto.domain.WinningChecker

class ResultView {

    fun inputWinningNumbers(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine() ?: ""
    }

    fun checkWinningLottoList(winningNumbers: String, lottoList: List<Lotto>): List<Winner> {
        return lottoList
            .map { lotto ->
                WinningChecker.win(winningNumbers, lotto.numbers)
            }
    }

    fun showResult(amount: Int, winners: List<Winner>) {
        println("\n당첨 통계")
        println("---------")

        val statics = LottoStatics(winners)
        val earningRate: Float = statics.calculateEarningRate(statics.totalReward, amount)
        val winningResult = statics.winningResult

        println("3개 일치 (5000원)- ${winningResult.numberOfFourthGrade}개")
        println("4개 일치 (50000원)- ${winningResult.numberOfThirdGrade}개")
        println("5개 일치 (1500000원)- ${winningResult.numberOfSecondGrade}개")
        println("6개 일치 (2000000000원)- ${winningResult.numberOfFirstGrade}개")
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
