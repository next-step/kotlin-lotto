package lotto.business

class LottoTicketManager(
    tickets: List<LottoTicket> = mutableListOf(),
    private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()
) {
    private val _tickets: MutableList<LottoTicket> = tickets.toMutableList()

    private val tickets: List<LottoTicket>
        get() = _tickets.toList()

    fun buyLotto(receivedAmount: ReceivedAmount): List<LottoTicket> {
        this._tickets.addAll(generateMultipleTickets(receivedAmount.getTicketCount()))
        return tickets
    }

    private fun generateSingleTicket(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick()
        return LottoTicket(lottoNumbers)
    }

    private fun generateMultipleTickets(quantity: Int): List<LottoTicket> {
        return (1..quantity).map { generateSingleTicket() }
    }
}
