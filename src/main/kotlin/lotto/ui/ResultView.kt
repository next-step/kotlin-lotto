package lotto.ui

import lotto.domain.LottoWinning
import lotto.domain.Lottos
import java.text.DecimalFormat

object ResultView {
    fun showBoughtLottos(lottos: Lottos) {
        println("${lottos.value.size}개를 구매했습니다.")
        lottos.value.forEach {
            println("numbers = ${it.numbers}")
        }
    }

    fun showResult(lottos: Lottos, returnRate: Double) {
        val winningLottos = lottos.value
            .groupBy { it.winning }

        println("당첨 통계")
        println("---------")
        LottoWinning.values()
            .filterNot { it == LottoWinning.Miss }
            .forEach { winning ->
                val winningCount = winningLottos[winning]?.size ?: 0

                val secondExplain = takeIf { winning == LottoWinning.Second }
                    ?.let { ", 보너스 볼 일치" }
                    ?: ""

                println("${winning.countOfMatch}개 일치$secondExplain (${winning.reward}원)- ${winningCount}개")
            }

        println("총 수익률은 ${returnRate.roundDecimal()}입니다.")
    }

    private fun Double.roundDecimal(): String {
        return DecimalFormat("#.##")
            .format(this)
    }
}
