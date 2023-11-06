package lotto.business

class LottoTicketGenerator(private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()) {
    fun generateSingleTicket(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick()
        return LottoTicket(lottoNumbers)
    }

    fun generateMultipleTickets(quantity: Int): List<LottoTicket> {
        return (1..quantity).map { generateSingleTicket() }
    }
}
