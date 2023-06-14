package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.ProfitRate
import lotto.domain.Rank

object LottoOutput {

    fun printLotto(lottos: Lottos) {
        val result = buildString {
            append("${lottos.size}개를 구매했습니다.\n")
            lottos.forEach { appendLottoNumber(it) }
        }

        println(result)
    }

    private fun StringBuilder.appendLottoNumber(lotto: Lotto) {
        append(lotto.lottoNumbers.joinToString(prefix = "[", postfix = "]"))
        append("\n")
    }

    fun printLottoResult(lottoResult: LottoResult) {
        val result = buildString {
            append("당첨 통계\n")
            append("---------\n")
            appendWinningStatistics(lottoResult.winningStatistics)
            appendProfitRate(lottoResult.profitRate)
        }

        println(result)
    }

    private fun StringBuilder.appendWinningStatistics(winningStatistics: Map<Rank, Int>) {
        winningStatistics.entries.filter { it.key != Rank.MISS }.reversed()
            .forEach {
                val rank = it.key
                append("${rank.matchCount}개 일치${", 보너스 볼 일치".takeIf { rank.isBonus } ?: ""} (${rank.reward}원)- ${it.value}\n")
            }
    }

    private fun StringBuilder.appendProfitRate(profitRate: ProfitRate) {
        append("총 수익율은 $profitRate 입니다.")
        append("(기준이 1이기 때문에 결과적으로 ${getProfitOrLossMessage(profitRate)} 의미임)\n")
    }

    private fun getProfitOrLossMessage(profitRate: ProfitRate) = "이익 이라는".takeIf { profitRate.isProfit } ?: "손해라는"
}
