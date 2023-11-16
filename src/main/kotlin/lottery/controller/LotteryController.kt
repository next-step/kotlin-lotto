package lottery.controller

import lottery.domain.InputNumberGenerator
import lottery.domain.LottoGame
import lottery.domain.LottoMachine
import lottery.domain.LottoMoney
import lottery.domain.RandomNumberGenerator
import lottery.domain.WinningLotto
import lottery.view.InputView
import lottery.view.OutputView

class LotteryController {
    fun start() {
        val money = LottoMoney(money = InputView.inputAmount(), manualLottoCount = InputView.inputManualLottoCount())
        InputView.inputManualLottoNumberMessage()
        val game = LottoGame(money, manualLottoMachine = LottoMachine(InputNumberGenerator()), autoLottoMachine = LottoMachine(RandomNumberGenerator()))
        OutputView.printLotteryInfo(game.userLottos, game.lottoMoney)

        val winningLotto = WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber())
        OutputView.printResult(game.getRanks(winningLotto))
    }
}
