package lotto.application

import lotto.domain.*
import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.WinningMachine
import lotto.domain.generator.RandomGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoService {

    fun main(args: Array<String>) {
        val lottoMachine = LottoMachine(RandomGenerator())
        val amountOfAutoLotto = InputView.requireAmountOfPurchaseLotto()
        val manualCount = InputView.requireCountOfPurchaseManualLotto()
        val amountOfManualLotto = Amount((LottoMachine.LOTTO_PRICE * manualCount))
        val manualLottos = lottoMachine.issue(amountOfManualLotto)
        val autoLottos = lottoMachine.issue(amountOfAutoLotto.sub(amountOfManualLotto))

        ResultView.printPurchaseLotto(manualLottos, autoLottos)

        val winLottoNum = Lotto(InputView.requireWinLottoNum())
        val bonusNum = LottoNum.of(InputView.requireWinBonusNum())
        val winningMachine = WinningMachine(WinLotto(winLottoNum, bonusNum))
        val statistics = winningMachine.match(autoLottos)
        ResultView.printStatistics(statistics, amountOfAutoLotto)
    }
}