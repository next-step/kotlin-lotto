package lotto.view

import lotto.domain.LottoMessage
import lotto.domain.LottoPurchase
import lotto.domain.LottoRank
import lotto.domain.LottoWinningReceipt
import lotto.domain.Lottos

object Output {

    fun printlnAny(message: Any) {
        println(message.toString())
    }

    fun lottoBuyResultPrint(lottos: Lottos) {
        this.printlnAny(LottoMessage.PRINT_PURCHASE_QUANTITY.format(lottos.autoQuantity, lottos.manualQuantity))
        this.printlnAny(getLottoBuyResult(lottos))
    }

    private fun getLottoBuyResult(lottos: Lottos): String =
        lottos.lines.joinToString("\n") {
            it.line.joinToString(", ", "[", "]")
        }

    fun lottoRateOfReturnPrint(lottoResult: LottoWinningReceipt, purchase: LottoPurchase) {
        this.printlnAny(LottoMessage.PRINT_LOTTO_RATE_OF_RETURN.format(lottoResult.getRateOfReturn(purchase)))
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
        if (rank == LottoRank.SECOND) LottoMessage.PRINT_LOTTO_BONUS_RANK
        else LottoMessage.PRINT_LOTTO_RANK

    private fun getLottoWinningRankAndQuantity(rank: LottoRank, lottoReceipt: LottoWinningReceipt): Pair<LottoRank, Int> {
        val quantity = lottoReceipt[rank] ?: 0
        return Pair(rank, quantity)
    }
}
