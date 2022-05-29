package lotto.domain

object LottoTicketMachine {

    fun generate(size: Int) = LottoTickets(List(size) { generateTicket() })

    private fun generateTicket(): LottoTicket =
        LottoTicket.AutoLottoTicket(
            LottoNumber.RANGE_OF_LOTTO_NUMBER
                .shuffled()
                .take(LottoTicket.SIZE_OF_LOTTO_NUMBER)
                .sorted()
                .map { LottoNumber(it) }
                .toSet()
        )
}
