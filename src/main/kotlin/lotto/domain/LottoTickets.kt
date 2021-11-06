package lotto.domain

class LottoTickets(val tickets: List<LottoNumbers>) {

    fun countRankingFrom(winning: WinningNumbers): Map<LottoRanking, Int> {
        return tickets.map { it.findRankingBy(winning) }
            .groupingBy { it }
            .eachCount()
    }

    private fun LottoNumbers.findRankingBy(winning: WinningNumbers): LottoRanking =
        LottoRanking.from(winning.countSameNumber(this), winning.containsBonus(this))
}

