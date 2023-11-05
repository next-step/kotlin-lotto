package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoMessage
import lotto.domain.LottoResult
import lotto.domain.LottoRank
import java.lang.IllegalArgumentException

object View {

    fun messagePrintAndGetLine(message: LottoMessage): String {
        println(message)
        return getLine()
    }

    fun lottoBuyResultPrint(lotto: Lotto) {
        println(LottoMessage.PRINT_PURCHASE_QUANTITY.message.format(lotto.lines.size))
        println(lotto.lines.joinToString("\n"))
    }

    private fun getLine() = readlnOrNull() ?: throw IllegalArgumentException("입력하여 주세요.")

    fun lottoRankStatisticsPrint(lottoResult: LottoResult) {
        val rankStatistics = LottoRank.values()
            .sortedBy { it.amount }
            .joinToString("\n") {
                val (sameCount, amount, quantity) = getLottoWinnings(it, lottoResult)
                LottoMessage.PRINT_LOTTO_RANK.message.format(
                    sameCount,
                    amount,
                    quantity
                )
            }
        println(LottoMessage.PRINT_LOTTO_STATISTICS)
        println(rankStatistics)
    }

    private fun getLottoWinnings(rank: LottoRank, lottoResult: LottoResult): Triple<Int, Int, Int> {
        val quantity = lottoResult[rank] ?: 0
        return Triple(rank.sameCount, rank.amount, quantity)
    }

}
