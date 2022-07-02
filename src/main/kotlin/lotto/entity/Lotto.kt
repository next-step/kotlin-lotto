package lotto.entity

import lotto.ui.InputView
import lotto.ui.ResultView

class Lotto {
    fun play() {
        val player = PersonImpl(Wallet(InputView().getPurchaseAmount()))
        val numberOfManualTicket = InputView().getNumberOfManualTickets()
        val manualMarkedTickets = InputView().getManualTicketNumbers(numberOfManualTicket)
        val markedWallet = player.mark(numberOfManualTicket, manualMarkedTickets)
        val manualPlayer = PersonImpl(markedWallet)
        val autoMarkedPlayer = PersonImpl(manualPlayer.purchase())
        ResultView().showLottoTickets(autoMarkedPlayer.wallet, numberOfManualTicket)
        val ranks = MatcherImpl(LottoNumber(InputView().getWinningNumbers(), InputView().getBonusNumber())).countTicketRanks(autoMarkedPlayer.wallet)
        ResultView().showMatchResult(player.money(), ranks)
    }
}
