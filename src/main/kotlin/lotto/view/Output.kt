package lotto.view

import lotto.domain.Customer
import lotto.domain.Lotto
import lotto.domain.LottoMessage
import lotto.domain.LottoRank
import lotto.domain.LottoResult

object Output {

    fun printlnAny(message: Any) {
        println(message.toString())
    }

    fun lottoBuyResultPrint(lotto: Lotto) {
        this.printlnAny(LottoMessage.PRINT_PURCHASE_QUANTITY.message.format(lotto.lines.size))
        this.printlnAny(lotto.lines.joinToString("\n") {
            it.line.joinToString(", ", "[", "]")
        })
    }

    fun lottoRateOfReturnPrint(lottoResult: LottoResult, customer: Customer) {
        this.printlnAny(LottoMessage.PRINT_LOTTO_RATE_OF_RETURN.message.format(lottoResult.getRateOfReturn(customer)))
    }

    fun lottoRankStatisticsPrint(lottoResult: LottoResult) {
        val rankStatistics = LottoRank.values()
            .sortedBy { it.amount }
            .joinToString("\n") {
                val (sameCount, amount, quantity) = this.getLottoWinnings(it, lottoResult)
                LottoMessage.PRINT_LOTTO_RANK.message.format(
                    sameCount,
                    amount,
                    quantity
                )
            }
        this.printlnAny(LottoMessage.PRINT_LOTTO_STATISTICS)
        this.printlnAny(rankStatistics)
    }

    private fun getLottoWinnings(rank: LottoRank, lottoResult: LottoResult): Triple<Int, Int, Int> {
        val quantity = lottoResult[rank] ?: 0
        return Triple(rank.sameCount, rank.amount, quantity)
    }
}
