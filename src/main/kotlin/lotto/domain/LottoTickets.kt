package lotto.domain

class LottoTickets(
    val items: List<LottoTicket>
) {
    fun count(): Int = items.size

    fun awardResults(winningTicket: WinningTicket): AwardResults {
        return AwardResults(
            Award.values().map {
                AwardResult(it, groupByAward(winningTicket).getOrDefault(it, 0))
            },
            LottoTicket.PRICE
        )
    }

    private fun groupByAward(winningTicket: WinningTicket): Map<Award, Int> {
        return items.map {
            winningTicket.match(it)
        }.groupingBy { it }.eachCount()
    }
}
