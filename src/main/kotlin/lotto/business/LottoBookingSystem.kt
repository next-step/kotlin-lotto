package lotto.business

import lotto.view.LottoInputHandler

class LottoBookingSystem(
    private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()
) {

    private fun generateSingleTicket(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick()
        return LottoTicket(lottoNumbers)
    }

    fun generateMultipleTickets(purchasableCount: Int): List<LottoTicket> {
        return (1..purchasableCount).map { generateSingleTicket() }
    }

    fun generateManualTickets(manualCount: Int, purchasableCount: Int): List<LottoTicket> {
        require(purchasableCount >= manualCount) { "구매 가능한 로또 개수보다 많습니다." }
        return LottoTicketExtractor.extractManualTicketNumbers(LottoInputHandler.inputManualNumbers(manualCount))
    }
}
