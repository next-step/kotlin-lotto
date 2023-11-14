package lottery.controller

import lottery.domain.AutoLottoMachine
import lottery.domain.LottoGame
import lottery.domain.LottoMoney
import lottery.domain.Lottos
import lottery.domain.ManualLottoMachine
import lottery.domain.RandomNumberGenerator
import lottery.domain.WinningLotto
import lottery.view.InputView
import lottery.view.OutputView

class LotteryController {
    fun start() {
        val money = LottoMoney.of(InputView.inputAmount(), InputView.inputManualLottoCount())
        val manualLotto = ManualLottoMachine.createLottos(InputView.inputManualLottoNumbers(money.manualLottoCount))
        val autoLotto = AutoLottoMachine(RandomNumberGenerator()).createLottos(money.autoLottoCount)
        val game = LottoGame(money, Lottos(manualLotto + autoLotto))
        OutputView.printLotteryInfo(game.getLottos(), money)

        val winningLotto = WinningLotto(InputView.inputWinningNumbers(), InputView.inputBonusNumber())
        OutputView.printResult(game.getRanks(winningLotto))
    }
}
