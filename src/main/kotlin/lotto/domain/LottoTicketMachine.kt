package lotto.domain

object LottoTicketMachine {

    fun generate(size: Int) = LottoTickets(List(size) { generateTicket() })

    private fun generateTicket(): LottoTicket {
        val lottoNumbers = LottoTicket.RANGE_OF_LOTTO_NUMBER
            .shuffled()
            .take(LottoTicket.SIZE_OF_LOTTO_NUMBER)
            .sorted()
            .toSet()
        return LottoTicket(lottoNumbers)
    }
}
