package lotto.business

class LottoBookingSystem(
    private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()
) {

    private fun generateSingleTicket(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick()
        return LottoTicket(lottoNumbers)
    }

    fun generateMultipleTickets(count: Int): List<LottoTicket> {
        return (1..count).map { generateSingleTicket() }
    }
}
