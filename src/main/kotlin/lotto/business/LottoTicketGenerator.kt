package lotto.business

object LottoTicketGenerator {
    fun generate(lottoNumbers: List<Int>): LottoTicket {
        return lottoNumbers.map { LottoBookingSystem.getLottoNumber(it) }
            .toSet().let { return LottoTicket(it) }
    }

    fun generateManualTickets(manualTicketNumbers: List<List<Int>>): List<LottoTicket> {
        return manualTicketNumbers.map(::generate)
    }
}
