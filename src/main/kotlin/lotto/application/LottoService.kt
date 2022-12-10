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
        val purchaseAmount = InputView.requireAmountOfPurchaseLotto()
        val lottos = lottoMachine.issue(purchaseAmount)
        ResultView.printPurchaseLotto(lottos)
        val winLottoNum = Lotto(InputView.requireWinLottoNum())
        val bonusNum = LottoNum.of(InputView.requireWinBonusNum())
        val winningMachine = WinningMachine(WinLotto(winLottoNum, bonusNum))
        val statistics = winningMachine.match(lottos)
        ResultView.printStatistics(statistics, purchaseAmount)
    }
}