package lotto.ui

import lotto.model.Lotto
import lotto.model.LottoGame
import lotto.model.LottoGrade

object ResultView {

    fun resultLottoList(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다 ")

        lottos.forEach {
            println(it.number)
        }
    }

    fun resultLottoWinner(lottoGame: LottoGame) {
        printLottoStat(lottoGame.getLottos())
        printWinningRate(lottoGame.winningRate())
    }

    private fun printLottoStat(lottos: List<Lotto>) {
        println("당첨 통계 ")
        println("---------")
        (3..6).forEach {
            printCorrectNumber(it, lottos)
        }
    }

    private fun printCorrectNumber(number: Int, lottos: List<Lotto>) {
        val grade = LottoGrade.find(number)
        val count = count(lottos, grade)
        println("${number}개 일치 (${grade.reward}원)- ${count}개")
    }

    private fun count(lottos: List<Lotto>, grade: LottoGrade) =
        lottos.count { it.grade == grade }

    private fun printWinningRate(winningRate: Double) {
        val message: String? = when {
            winningRate < 1.0 -> "손해"
            winningRate == 1.0 -> "본전"
            winningRate > 1.0 -> "이득"
            else -> null
        }
        println("총 수익률은 ${winningRate}입니다.(기준이 1이기 때문에 결과적으로 ${message}라는 의미임) ")
    }
}
