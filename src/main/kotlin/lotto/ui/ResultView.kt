package lotto.ui

import lotto.Lotto
import lotto.LottoWinning
import java.text.DecimalFormat

object ResultView {
    fun showResult(lottos: List<Lotto>, investmentMoney: Int) {
        val winningLottos = lottos
            .groupBy { it.winning }

        val returnRate = calculateReturnRate(lottos, investmentMoney)

        println("당첨 통계")
        println("---------")
        LottoWinning.values()
            .filterNot { it == LottoWinning.Nothing }
            .forEach { winning ->
                val winningCount = winningLottos[winning]?.size ?: 0

                println("${winning.correctCount}개 일치 (${winning.reward}원)- ${winningCount}개")
            }

        println("총 수익률은 ${returnRate.roundDecimal()}입니다.")
    }

    private fun calculateReturnRate(lottos: List<Lotto>, investmentMoney: Int): Double {
        val totalReward = lottos
            .map { it.winning }
            .sumOf { it.reward }

        return totalReward / investmentMoney.toDouble()
    }

    private fun Double.roundDecimal(): String {
        return DecimalFormat("#.##")
            .format(this)
    }
}
