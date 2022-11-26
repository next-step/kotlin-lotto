package lotto.domain

class LottoTickets(
    val items: List<LottoTicket>
) {
    fun count(): Int = items.size

    fun awardResults(winningTicket: LottoTicket): AwardResults {
        return AwardResults(
            Award.values().map {
                AwardResult(it, groupByAward(winningTicket).getOrDefault(it, 0))
            }
        )
    }

    private fun groupByAward(winningTicket: LottoTicket): Map<Award, Int> {
        return items.map {
            it.matchScratch(winningTicket)
        }.groupingBy { it }.eachCount()
    }

    companion object {
        fun randomTickets(count: Int): LottoTickets {
            require(count > 0) { "$count 는 양수만 올 수 있어요." }

            return LottoTickets(
                (0 until count).map { LottoTicket.randomTicket() }
            )
        }
    }
}
