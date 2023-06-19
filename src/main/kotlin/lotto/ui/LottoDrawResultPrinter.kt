package lotto.ui

import lotto.domain.LottoDrawResult
import lotto.domain.LottoRank
import java.text.DecimalFormat

object LottoDrawResultPrinter {

    private val profitabilityFormat: DecimalFormat = DecimalFormat("#.##")
    fun print(lottoDrawResult: LottoDrawResult) {
        println("당첨 통계")
        println("---------")
        val LottoRanks = listOf(LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST)

        LottoRanks.forEach {
            println("${it.matchingCount}개 일치 (${it.reward}원)- ${lottoDrawResult.countOf(it)}개")
        }

        println("총 수익률은 ${profitabilityFormat.format(lottoDrawResult.profitability())}입니다.")
    }
}
