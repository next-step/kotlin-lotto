package lotto.controller

import lotto.service.LottoDrawService
import lotto.service.LottoDrawSpec
import lotto.service.LottoIssueService
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

object LottoController {
    fun handle() {
        val purchaseAmount = LottoInputView.readPurchaseAmountInput()

        val lottos = LottoIssueService.issue(purchaseAmount)

        LottoOutputView.printLottoOutput(lottos.size, lottos)

        val winningNumbers = LottoInputView.readWinningNumbersInput()

        val lottoDrawSpec = LottoDrawSpec(
            lottos = lottos,
            winningNumbers = winningNumbers,
            purchaseAmount = purchaseAmount,
        )
        val winningStatistic = LottoDrawService.draw(lottoDrawSpec)

        LottoOutputView.printWinningStatistic(winningStatistic)
    }
}
