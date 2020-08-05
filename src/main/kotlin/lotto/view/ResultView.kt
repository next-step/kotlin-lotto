package lotto.view

import lotto.model.Lotto
import lotto.model.Win

object ResultView {
    fun printLottoCount(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
    }

    fun printLottos(lottos: List<Lotto>) {
        lottos.forEach {
            println("${it.numbers}")
        }
    }

    fun printMatchResult(result: List<Lotto>) {
        println("당첨 통계")
        println("---------")

        Win.values().filter { it.hasPrize() }.forEach { win ->
            var resultSentence = "${win.matchNumber}개 일치"

            if (win.matchBonus) {
                resultSentence += ", 보너스 볼 일치"
            }

            resultSentence += "(${win.prize.money}원)- ${result.filter { it.win == win }.size}개"

            println(resultSentence)
        }
    }

    fun printEarningRate(result: Double) {
        println("총 수익률은 ${result}입니다.")
    }
}
