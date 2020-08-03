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

        Win.values().filter { it.prize > 0 }.forEach { win ->
            println("${win.matchNumber}개 일치 - ${result.filter { it.win.matchNumber == win.matchNumber }.size}개")
        }
    }

    fun printEarningRate(result: Double) {
        println("총 수익률은 ${result}입니다.")
    }
}
