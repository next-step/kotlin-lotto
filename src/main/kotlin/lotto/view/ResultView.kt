package lotto.view

import lotto.model.Lotto
import lotto.model.Win

private const val HAS_BONUS_NUMBER = 1

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

        Win.values().filter { hasPrize(it.prize) }.forEach { win ->
            val infoMsg = if (win.matchBonusNumber == HAS_BONUS_NUMBER) ", 보너스 볼 일치" else ""

            val resultSentence =
                "${win.matchNumber}개 일치${infoMsg}(${win.prize}원)- ${result.filter { it.win == win }.size}개"

            println(resultSentence)
        }
    }

    private fun hasPrize(prize: Int): Boolean = prize > 0

    fun printEarningRate(result: Double) {
        println("총 수익률은 ${result}입니다.")
    }
}
