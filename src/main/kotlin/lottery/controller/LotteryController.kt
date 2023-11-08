package lottery.controller

import lottery.domain.LottoGame
import lottery.domain.RandomNumberGenerator
import lottery.domain.WinningLotto
import lottery.view.InputView
import lottery.view.OutputView

class LotteryController {
    fun start() {
        val game = LottoGame(InputView.inputAmount(), RandomNumberGenerator())
        OutputView.printLotteryInfo(game.getLottos())

        val winningLotto = WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber())
        OutputView.printResult(game.getRanks(winningLotto))
    }
}
