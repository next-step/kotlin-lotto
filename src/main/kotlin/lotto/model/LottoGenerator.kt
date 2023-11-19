package lotto.model

object LottoGenerator {
    private fun getLottoNumbers(shuffled: Iterable<Int>.() -> List<Int>): List<LottoNumber> =
        (LottoNumber.NUMBER_RANGE).shuffled().take(
            LottoTicket.NUMBER_COUNT
        ).map { LottoNumber.from(it) }

    fun generateAutoTickets(
        ticketCount: Int,
        shuffled: Iterable<Int>.() -> List<Int>
    ): List<LottoTicket> = List(ticketCount) {
        LottoTicket(numbers = getLottoNumbers(shuffled))
    }

    fun generateManualTickets(
        manualNumbers: List<List<LottoNumber>>,
    ): List<LottoTicket> = manualNumbers.map { LottoTicket(it) }

}
