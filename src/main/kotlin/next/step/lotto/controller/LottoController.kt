package next.step.lotto.controller

import next.step.lotto.domain.LottoNumberGenerator
import next.step.lotto.domain.LottoStore
import next.step.lotto.domain.WinningLotto
import next.step.racing.view.InputView
import next.step.racing.view.OutputView

fun main() {
    runCatching {
        val payment = InputView.readPayment()
        val lottos = LottoStore.buy(payment, LottoNumberGenerator.random())
        OutputView.showLottos(lottos)
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()
        val winningStat = WinningLotto.of(winningNumbers, bonusNumber).match(lottos)
        OutputView.showWinningStats(winningStat)
        OutputView.showPerformance(winningStat.performance(payment))
    }.onFailure { e ->
        OutputView.showError(e.message)
        main()
    }
}
