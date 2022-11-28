package lotto.ui

import lotto.domain.*

class ResultView {

    fun inputWinningNumbers(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine() ?: ""
    }

    fun checkWinningLottoList(winningNumbers: String, lottoList: List<Lotto>): List<Winner> {
        return lottoList
            .map { lotto ->
                WinningChecker.win(winningNumbers, lotto.list)
            }
    }

    fun showResult(amount: Int, winners: List<Winner>) {
        println("\n당첨 통계")
        println("---------")

        val statics = LottoStatics()
        val (grade: WinningGrade, earningRate: Float) = statics.makeStatics(amount, winners)

        println("3개 일치 (5000원)- ${grade.three}개")
        println("4개 일치 (50000원)- ${grade.four}개")
        println("5개 일치 (1500000원)- ${grade.five}개")
        println("6개 일치 (2000000000원)- ${grade.six}개")
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
