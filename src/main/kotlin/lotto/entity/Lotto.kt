package lotto.entity

import lotto.ui.InputView
import lotto.ui.ResultView

class Lotto {
    fun play() {
        val wallet: Wallet = Wallet(InputView().getPurchaseAmount())
        val player: Player = Player(wallet)
        val result = WithoutBonusMatcherImpl().match(InputView().getWinningNumbers(), player.getTickets())
        ResultView().showMatchResult(result)
    }
}
