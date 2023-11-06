package lottery.controller

import lottery.domain.Lotto
import lottery.domain.LottoGame
import lottery.domain.RandomNumberGenerator
import lottery.view.InputView
import lottery.view.OutputView

class LotteryController {
    fun start() {
        val game = LottoGame(InputView.inputAmount(), RandomNumberGenerator())
        OutputView.printLotteryInfo(game.getLottos())

        val winningLotto = Lotto(InputView.inputWinningNumbers())
        OutputView.printResult(game.getRanks(winningLotto))
    }
}
