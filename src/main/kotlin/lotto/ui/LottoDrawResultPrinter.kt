package lotto.ui

import lotto.domain.LottoDrawResult
import lotto.domain.LottoRank
import java.text.DecimalFormat

object LottoDrawResultPrinter {

    private val profitabilityFormat: DecimalFormat = DecimalFormat("#.##")
    fun print(lottoDrawResult: LottoDrawResult) {
        println("당첨 통계")
        println("---------")
        val LottoRanks = listOf(LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)

        LottoRanks.forEach {
            println("${it.matchingCount}개 일치${printMatchBonusText(it.matchBonus)}(${it.reward}원)- ${lottoDrawResult.countOf(it)}개")
        }

        println("총 수익률은 ${profitabilityFormat.format(lottoDrawResult.profitability())}입니다.")
    }
    private fun printMatchBonusText(matchBonus: Boolean): String = if (matchBonus) ", 보너스 볼 일치" else ""
}
