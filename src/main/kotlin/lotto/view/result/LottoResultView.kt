package lotto.view.result

import lotto.view.dto.LottoResultsDto

object LottoResultView {
    fun print(dto: LottoResultsDto) {
        val sb = StringBuilder()
        printTitle(sb)
        printWinCountInfo(sb, dto)
        printProfitRate(sb, dto)
        println(sb.toString())
    }

    private fun printTitle(sb: StringBuilder) {
        sb.append("당첨 통계\n")
        sb.append("---------\n")
    }

    private fun printWinCountInfo(
        sb: StringBuilder,
        dto: LottoResultsDto,
    ) {
        dto.winResults.forEach {
            sb.append("${it.matchCount}개 일치 ${if (it.containBonus) ", 보너스 볼 일치" else ""}(${it.reward}원) - ${it.winCount}개\n")
        }
    }

    private fun printProfitRate(
        sb: StringBuilder,
        dto: LottoResultsDto,
    ) {
        val profitOrLoss = if (dto.isProfit) "이익" else "손해"
        sb.append("총 수익률은 ${dto.profitRate}입니다. 기준이 ${dto.margin}이기 때문에 결과적으로 ${profitOrLoss}라는 의미임.")
    }
}
