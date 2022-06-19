package lotto.entity

import lotto.ui.InputView
import lotto.ui.ResultView

class Lotto {
    fun play() {
        val player: Person = PersonImpl(Wallet(InputView().getPurchaseAmount()))
        val tickets = player.purchase()
        ResultView().showLottoTickets(tickets)
        val ranks = MatcherImpl(InputView().getWinningNumbers()).countTicketRanks(tickets)
        ResultView().showMatchResult(player.money(), ranks)
    }
}
