package lotto.domain

class LottoTickets(
    val items: List<LottoTicket>
) {
    fun count(): Int = items.size

    fun benefitPrice(winningTicket: LottoTicket): Long {
        return getResult(winningTicket).map { it.key.prize * it.value }.sum()
    }

    fun getResult(winningTicket: LottoTicket): Map<Award, Int> {
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
