package next.step.lotto.controller

import next.step.lotto.domain.LottoNumberRandomGenerator
import next.step.lotto.domain.LottoStore
import next.step.lotto.domain.WinningLotto
import next.step.racing.view.InputView
import next.step.racing.view.OutputView

fun main() {
    runCatching {
        val payment = InputView.readPayment()
        val manualLottos = InputView.readManualLottos()
        val lottoStore = LottoStore.of(LottoNumberRandomGenerator)
        val remained = lottoStore.buy(payment, manualLottos)
        val randomLottos = lottoStore.buy(remained)
        OutputView.showLottos(manualLottos, randomLottos)
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()
        val winningStat = WinningLotto.of(winningNumbers, bonusNumber).match(manualLottos + randomLottos)
        OutputView.showWinningStats(winningStat)
        OutputView.showPerformance(winningStat.performance(payment))
    }.onFailure { e ->
        OutputView.showError(e.message)
        main()
    }
}
