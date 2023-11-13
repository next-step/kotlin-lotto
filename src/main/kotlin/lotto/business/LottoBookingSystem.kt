package lotto.business

import lotto.view.LottoInputHandler

class LottoBookingSystem(
    private val randomLottoPicker: RandomLottoPicker = RandomLottoPicker()
) {

    private fun generateSingleTicket(): LottoTicket {
        val lottoNumbers = randomLottoPicker.pick()
        return LottoTicket(lottoNumbers)
    }

    fun generateMultipleTickets(player: Player): List<LottoTicket> {
        return (1..player.purchasableCount).map { generateSingleTicket() }
    }

    fun generateManualTickets(manualCount: Int, player: Player): List<LottoTicket> {
        require(player.purchasableCount >= manualCount) { "구매 가능한 로또 개수보다 많습니다." }
        return LottoTicketExtractor.extractManualTicketNumbers(LottoInputHandler.inputManualNumbers(manualCount))
    }
}
