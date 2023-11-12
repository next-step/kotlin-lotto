package lotto.view

import lotto.domain.*

object Output {

    fun printlnAny(message: Any) {
        println(message.toString())
    }

    fun lottoBuyResultPrint(lotto: Lotto) {
        this.printlnAny(LottoMessage.PRINT_PURCHASE_QUANTITY.message.format(lotto.manualLines.size, lotto.autoLines.size))
        this.printlnAny(getLottoBuyResult(lotto))
    }

    private fun getLottoBuyResult(lotto: Lotto): String =
        lotto.allLines.joinToString("\n") {
            it.line.joinToString(", ", "[", "]")
        }

    fun lottoRateOfReturnPrint(lottoResult: LottoWinningReceipt, purchase: LottoPurchase) {
        this.printlnAny(LottoMessage.PRINT_LOTTO_RATE_OF_RETURN.message.format(lottoResult.getRateOfReturn(purchase)))
    }

    fun lottoRankStatisticsPrint(lottoResult: LottoWinningReceipt) {
        val rankStatistics = LottoRank.values()
            .filter { it != LottoRank.MISS }
            .sortedBy { it.winningMoney }
            .joinToString("\n") {
                val (rank, quantity) = this.getLottoWinningRankAndQuantity(it, lottoResult)
                getPrintRankMessage(rank).format(
                    rank.countOfMatch,
                    rank.winningMoney,
                    quantity
                )
            }
        this.printlnAny(LottoMessage.PRINT_LOTTO_STATISTICS)
        this.printlnAny(rankStatistics)
    }

    private fun getPrintRankMessage(rank: LottoRank) =
        if (rank == LottoRank.SECOND) LottoMessage.PRINT_LOTTO_BONUS_RANK.message
        else LottoMessage.PRINT_LOTTO_RANK.message

    private fun getLottoWinningRankAndQuantity(rank: LottoRank, lottoReceipt: LottoWinningReceipt): Pair<LottoRank, Int> {
        val quantity = lottoReceipt[rank] ?: 0
        return Pair(rank, quantity)
    }
}
