package next.step.lotto.controller

import next.step.lotto.domain.Lottos
import next.step.racing.view.InputView
import next.step.racing.view.OutputView

fun main() {
    runCatching {
        val payment = InputView.readPayment()
        val lottos = Lottos.buy(payment)
        OutputView.showLottos(lottos)
        val winningNumbers = InputView.readWinningNumbers()
        val winningStat = lottos.match(winningNumbers)
        OutputView.showWinningStats(winningStat)
        OutputView.showPerformance(winningStat.performance(payment))
    }.onFailure { e ->
        OutputView.showError(e.message)
        main()
    }
}
