package lotto.application

import lotto.domain.*
import lotto.domain.generator.RandomGenerator
import lotto.view.InputView
import lotto.view.ResultView

class LottoService {

    fun main() {
        val lottoMachine = LottoMachine(RandomGenerator())
        val purchaseAmount = InputView.requireAmountOfPurchaseLotto()
        val lottos = lottoMachine.issue(purchaseAmount)
        ResultView.printPurchaseLotto(lottos)

        val winLottoNum = Lotto(InputView.requireWinLottoNum())
        val bonusNum = LottoNum(InputView.requireWinBonusNum())
        val winningMachine = WinningMachine(WinLotto(winLottoNum, bonusNum))
        val statistics = winningMachine.match(lottos)
        ResultView.printStatistics(statistics, purchaseAmount)
    }
}