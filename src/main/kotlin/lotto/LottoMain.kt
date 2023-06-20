package lotto

import lotto.domain.Lotto
import lotto.domain.RandomLottoGenerator
import lotto.domain.WinningLotto
import lotto.service.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val manualLottoCount = InputView.readManualLottoCount()
    val manualLottos = InputView.readManualLottos(manualLottoCount)

    val lottoMachine = LottoMachine(purchaseAmount, manualLottos, RandomLottoGenerator())

    ResultView.printLottos(lottoMachine.lottos, manualLottoCount)

    val winningLottoNumbers = InputView.readWinningLottoNumbers()
    val bonusNumber = InputView.readBonusLottoNumber()
    val winningLotto = WinningLotto(Lotto(winningLottoNumbers), bonusNumber)

    ResultView.printWinnerStatistics(
        winningLottoPrizeVOs = lottoMachine.matchWinningLottoPrize(winningLotto),
        totalProfitRate = lottoMachine.getTotalProfitRate(winningLotto),
    )
}
