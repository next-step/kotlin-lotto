package lotto.model

object LottoGenerator {
    private val LOTTO_NUMBERS = (LottoNumber.NUMBER_RANGE).map { LottoNumber.from(it) }
    private fun getLottoNumbers(): List<LottoNumber> =
        (LOTTO_NUMBERS).shuffled().take(
            LottoTicket.NUMBER_COUNT
        )

    fun generateAutoTickets(
        ticketCount: Int
    ): List<LottoTicket> = List(ticketCount) {
        LottoTicket(numbers = getLottoNumbers())
    }

    fun generateManualTickets(
        manualNumbers: List<ManualNumber>,
    ): List<LottoTicket> = manualNumbers.map { LottoTicket(it.numbers) }
}
