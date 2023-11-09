package lotto.view

import lotto.domain.Customer
import lotto.domain.Lotto
import lotto.domain.LottoMessage
import lotto.domain.LottoRank
import lotto.domain.LottoWinningReceipt
import lotto.domain.LottoWinningResult

object Output {

    fun printlnAny(message: Any) {
        println(message.toString())
    }

    fun lottoBuyResultPrint(lotto: Lotto) {
        this.printlnAny(LottoMessage.PRINT_PURCHASE_QUANTITY.message.format(lotto.lines.size))
        this.printlnAny(
            lotto.lines.joinToString("\n") {
                it.line.joinToString(", ", "[", "]")
            }
        )
    }

    fun lottoRateOfReturnPrint(lottoResult: LottoWinningReceipt, customer: Customer) {
        this.printlnAny(LottoMessage.PRINT_LOTTO_RATE_OF_RETURN.message.format(lottoResult.getRateOfReturn(customer)))
    }

    fun lottoRankStatisticsPrint(lottoResult: LottoWinningReceipt) {
        val rankStatistics = LottoRank.values()
            .sortedBy { it.amount }
            .joinToString("\n") {
                val (winningResult, amount, quantity) = this.getLottoWinnings(it, lottoResult)
                getPrintRankMessage(winningResult.isBonusRank).format(
                    winningResult.sameCount,
                    amount,
                    quantity
                )
            }
        this.printlnAny(LottoMessage.PRINT_LOTTO_STATISTICS)
        this.printlnAny(rankStatistics)
    }

    private fun getPrintRankMessage(bonusRank: Boolean) =
        if (bonusRank) LottoMessage.PRINT_LOTTO_BONUS_RANK.message
        else LottoMessage.PRINT_LOTTO_RANK.message

    private fun getLottoWinnings(rank: LottoRank, lottoReceipt: LottoWinningReceipt): Triple<LottoWinningResult, Int, Int> {
        val quantity = lottoReceipt[rank] ?: 0
        return Triple(rank.lottoWinningResult, rank.amount, quantity)
    }
}
