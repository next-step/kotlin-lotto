package lotto.domain

class LottoTickets(val tickets: List<LottoNumbers>) {

    fun count(): LottoTicketCount = LottoTicketCount(tickets.size)

    fun countRankingFrom(winning: LottoNumbers): Map<LottoRanking, Int> {
        return tickets.map { it.findRankingBy(winning) }
            .groupingBy { it }
            .eachCount()
    }

    private fun LottoNumbers.findRankingBy(winning: LottoNumbers): LottoRanking =
        LottoRanking.from(winning.countSameNumber(this))
}

