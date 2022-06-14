package lotto.entity

import lotto.ui.InputView
import lotto.ui.ResultView

class Lotto {
    fun play() {
        val wallet = Wallet(InputView().getPurchaseAmount())
        val player: Person = PersonImpl(wallet)
        val tickets = player.purchase()
        ResultView().showLottoTickets(tickets)
        val ranks = MatcherImpl(InputView().getWinningNumbers()).matchTicketsToRanks(tickets)
        ResultView().showMatchResult(wallet.money, ranks)
    }
}
