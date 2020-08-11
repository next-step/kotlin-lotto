package lotto.domain

class LottoAnalytics {
    fun matchTickets(tickets: List<Ticket>, winnerTicket: Ticket): LottoResult {
        return LottoResult().also { result ->
            tickets.forEach {
                result[Rank.of(winnerTicket.countMatches(it))]++
            }
        }
    }

    fun totalProfitRate(results: LottoResult): Float {
        return results.collectAllPrizes().toFloat() / (results.cost).toFloat()
    }
}
