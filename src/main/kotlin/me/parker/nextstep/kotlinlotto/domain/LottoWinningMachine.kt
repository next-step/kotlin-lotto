package me.parker.nextstep.kotlinlotto.domain

object LottoWinningMachine {
    fun result(
        wonLottoTicket: LottoTicket,
        boughtLottoTickets: List<LottoTicket>,
        bonusLottoNumber: LottoNumber
    ): LottoResult {
        val rankMatchCounts: MutableMap<LottoRank, Int> = LottoRank.values().associateWithTo(mutableMapOf()) { 0 }
        boughtLottoTickets
            .map { it.match(wonLottoTicket, bonusLottoNumber) }
            .groupBy { it }
            .mapValues { it.value.size }
            .forEach { (rank, count) ->
                rankMatchCounts[rank] = count
            }

        val amountOfTotalPurchase = boughtLottoTickets.size * LottoTicket.PRICE
        val amountOfTotalWinning = rankMatchCounts
            .map { it.key.prize * it.value }
            .sum()
        val profitRate = amountOfTotalWinning.toDouble() / amountOfTotalPurchase.toDouble()

        return LottoResult(rankMatchCounts, profitRate)
    }
}
