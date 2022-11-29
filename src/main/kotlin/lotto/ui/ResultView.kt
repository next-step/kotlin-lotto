package lotto.ui

import lotto.model.LottoGame
import lotto.model.LottoGrade
import lotto.model.LottoStat
import java.math.BigDecimal

object ResultView {

    fun resultLottoList(lottoGame: LottoGame) {
        val lottos = lottoGame.getLottos()
        val directLottoCount = lottoGame.getDirectLottoCount()
        println("수동으로 ${directLottoCount}장, 자동으로 ${lottos.size - directLottoCount}개를 구매했습니다.")

        lottos.forEach {
            println(it.numbers.toString())
        }
    }

    fun resultLottoWinner(lottoStat: LottoStat) {
        printLottoStat(lottoStat.gradeStat)
        printWinningRate(lottoStat.winningRate, lottoStat.winningMessage())
    }

    private fun printLottoStat(gradeStat: Map<LottoGrade, Int>) {
        println("당첨 통계 ")
        println("---------")
        gradeStat.forEach { (grade, count) ->
            print("${grade.correctNumber}개 일치")
            if (grade.matchPlus) {
                print(", 보너스 볼 일치")
            }
            println("(${grade.reward}원) - ${count}개")
        }
    }

    private fun printWinningRate(winningRate: BigDecimal, message: String) {
        println("총 수익률은 ${winningRate}입니다.(기준이 1이기 때문에 결과적으로 ${message}라는 의미임) ")
    }
}
