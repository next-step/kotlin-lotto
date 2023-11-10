package lotto.model

object LottoGenerator {
    private fun getLottoNumbers (shuffled: Iterable<Int>.() -> List<Int>) = (LottoNumber.NUMBER_RANGE).shuffled().take(
        LottoTicket.NUMBER_COUNT).map { LottoNumber.from(it) }

    fun generateTickets(ticketCount: Int, shuffled: Iterable<Int>.() -> List<Int>): List<LottoTicket> = List(ticketCount) {
        LottoTicket(getLottoNumbers(shuffled))
    }
}
