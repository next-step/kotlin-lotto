package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoStatics
import lotto.domain.WinningGrade

class ResultView {

    fun checkWinningNumber(lottoList: List<Lotto>) {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readLine() ?: ""
        checkWinningLotto(lottoList, winningNumbers)
    }

    private fun checkWinningLotto(lottoList: List<Lotto>, winningNumbers: String) {
        lottoList.forEach { it.win(winningNumbers) }
    }

    fun showResult(amount: Int, lottoList: List<Lotto>) {
        println("\n당첨 통계")
        println("---------")

        val statics = LottoStatics()
        val (grade: WinningGrade, earningRate: Float) = statics.makeStatics(amount, lottoList)

        println("3개 일치 (5000원)- ${grade.three}개")
        println("4개 일치 (50000원)- ${grade.four}개")
        println("5개 일치 (1500000원)- ${grade.five}개")
        println("6개 일치 (2000000000원)- ${grade.six}개")
        println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
