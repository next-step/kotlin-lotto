package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoLine
import lotto.domain.LottoResult
import lotto.domain.Payment
import lotto.domain.Rank

object ResultView {
    private const val COMMA_SEPARATOR = ", "
    private val NEWLINE = System.lineSeparator()

    fun printLotto(lotto: Lotto) {
        val sb = StringBuilder()
        sb.append("${lotto.numberOfLines}개를 구먀했습니다.$NEWLINE")
        lotto.lines
            .forEach { sb.append(formatLine(it)) }
        println(sb.toString())
    }

    private fun formatLine(
        line: LottoLine,
        prefix: String = "[",
        postfix: String = "]$NEWLINE",
    ): String {
        val numbers = line.numbers.map { it.value }
        return numbers.joinToString(COMMA_SEPARATOR, prefix, postfix)
    }

    fun printResult(
        result: LottoResult,
        payment: Payment,
    ) {
        val sb = StringBuilder()
        sb.append("${NEWLINE}당첨 통계$NEWLINE---------$NEWLINE")

        val ranksSortedByPrize =
            Rank.entries
                .sortedBy { it.prize }
        ranksSortedByPrize
            .forEach { sb.append(formatResultByRank(it, result.get(it))) }

        val roi = result.returnOnInvestment(payment)
        sb.append(formatReturnOnInvestment(roi))

        println(sb.toString())
    }

    private fun formatResultByRank(
        rank: Rank,
        count: Int,
    ): String {
        if (rank == Rank.MISS) {
            return ""
        }
        return "${rank.count}개 일치 (${rank.prize}원)- ${count}개$NEWLINE"
    }

    private fun formatReturnOnInvestment(roi: Double): String {
        val formattedRoi = "%.2f".format(roi)
        return "총 수익률은 ${formattedRoi}입니다.(기준이 1이기 때문에 결과적으로 ${if (roi > 1.0) "수익이" else "손해"}라는 의미임)"
    }
}
