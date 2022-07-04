package lotto.ui

import lotto.entity.LottoNumber
import lotto.entity.MatcherImpl
import lotto.entity.PersonImpl
import lotto.entity.Wallet

class Lotto(private val resultView: ResultView) {

    fun play() {
        val player = PersonImpl(Wallet(InputView.getPurchaseAmount()))
        val numberOfManualTicket = InputView.getNumberOfManualTickets()
        val manualMarkedTickets = InputView.getManualTicketNumbers(numberOfManualTicket)
        val manualPlayer = player.markLottoTicket(numberOfManualTicket, manualMarkedTickets)
        val autoMarkedPlayer = manualPlayer.purchaseLottoTicket()
        resultView.showLottoTickets(autoMarkedPlayer.wallet, numberOfManualTicket)
        val ranks = MatcherImpl(LottoNumber(InputView.getWinningNumbers(), InputView.getBonusNumber())).countTicketRanks(autoMarkedPlayer.wallet)
        resultView.showMatchResult(player.getMoney(), ranks)
    }
}
