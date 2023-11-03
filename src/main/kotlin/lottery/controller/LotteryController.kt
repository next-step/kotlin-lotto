package lottery.controller

import lottery.domain.LottoGame
import lottery.view.InputView
import lottery.view.OutputView

class LotteryController {
    fun start() {
        val game = LottoGame(InputView.inputAmount())
        OutputView.printLotteryAmount(game.amount)
    }
}
