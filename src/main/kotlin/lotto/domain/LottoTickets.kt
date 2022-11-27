package lotto.domain

class LottoTickets(
    val items: List<LottoTicket>
) {
    fun count(): Int = items.size

    fun awardResults(winningTicket: WinningTicket): AwardResults {
        return AwardResults(
            Award.values().map {
                AwardResult(it, groupByAward(winningTicket).getOrDefault(it, 0))
            }
        )
    }

    private fun groupByAward(winningTicket: WinningTicket): Map<Award, Int> {
        return items.map {
            it.matchScratch(winningTicket)
        }.groupingBy { it }.eachCount()
    }
}
