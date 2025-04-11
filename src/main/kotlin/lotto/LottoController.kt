package lotto

import lotto.machine.AutoMachine
import lotto.machine.ManualMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController(private val inputView: InputView, private val resultView: ResultView) {
    fun run() {
        val lottoStore = LottoStore()

        val amount = inputView.getPurchaseAmount()

        val manualTicketCount = inputView.getManualTicketCount()
        val manualLottoNumbers = List(manualTicketCount) { inputView.getManualLottosNumbers() }

        val order = Order(amount, manualTicketCount, manualLottoNumbers)

        val lottos = lottoStore.sell(order, ManualMachine()) + lottoStore.sell(order, AutoMachine())
        resultView.printLottos(order, lottos)

        val winningLotto = inputView.getWinningNumbers()
        val winningStatistics = WinningStatistics(lottos, winningLotto)

        resultView.printWinningStatistics(amount, winningStatistics)
    }
}
