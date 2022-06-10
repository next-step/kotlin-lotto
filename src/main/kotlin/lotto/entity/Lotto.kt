package lotto.entity

import lotto.ui.InputView
import lotto.ui.ResultView

class Lotto {
    fun play() {
        val wallet = Wallet(InputView().getPurchaseAmount())
        val player: Person = PersonImpl(wallet)
        val tickets = player.purchase()
        ResultView().showLottoTickets(tickets)
        val winningNumbers = InputView().getWinningNumbers()
        val result = MatcherImpl(winningNumbers).matchAllTickets(tickets)

        ResultView().showMatchResult(wallet.money, result)
    }
}
