package lotto.domain

class LottoTickets(tickets: List<LottoNumbers>) {

    val tickets = tickets.toList()

    fun countRankingFrom(winning: WinningNumbers): Map<LottoRanking, Int> {
        return tickets.map { it.findRankingBy(winning) }
            .groupingBy { it }
            .eachCount()
    }

    private fun LottoNumbers.findRankingBy(winning: WinningNumbers): LottoRanking =
        LottoRanking.from(winning.countSameNumber(this), winning.containsBonus(this))

    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(tickets + other.tickets)
    }
}

