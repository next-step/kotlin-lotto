package lottery.controller

import lottery.domain.LottoGame
import lottery.view.InputView

class LotteryController {
    fun start() {
        LottoGame(InputView.inputAmount())
    }
}
