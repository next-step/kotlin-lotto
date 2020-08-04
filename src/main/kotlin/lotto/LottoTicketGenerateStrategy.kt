package lotto

interface LottoTicketGenerateStrategy {

    fun createAutoTicket(): LottoTicket

    fun createManualTicket(numbers: List<Int>): LottoTicket
}
