package lotto2.domain

object LottoFactory {

    fun generate(ticketQuantity: Int): List<LottoTicket> {
        val randomNumbers = LottoNumber.ALL_NUMBERS
            .shuffled()
            .take(LottoNumbers.MAIN_LOTTO_NUMBERS_COUNT)
            .sortedBy { it.number }

        return List(ticketQuantity) { LottoTicket(LottoNumbers(randomNumbers)) }
    }

    fun generate(manualTicketNumbers: List<LottoNumbers>): List<LottoTicket> {
        return manualTicketNumbers.map { LottoTicket(it) }
    }
}
