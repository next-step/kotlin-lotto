package me.parker.nextstep.kotlinlotto.domain

class LottoWinningMachine(
    private val wonLottoTicket: LottoTicket,
    private val boughtLottoTickets: List<LottoTicket>
) {
    fun result(): LottoResult {
        val rankMatchCounts: MutableMap<LottoRank, Int> = LottoRank.values().associateWithTo(mutableMapOf()) { 0 }
        boughtLottoTickets
            .map { it.match(wonLottoTicket) }
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
