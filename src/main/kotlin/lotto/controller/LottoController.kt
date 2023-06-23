package lotto.controller

import lotto.domain.Lotto
import lotto.ui.InputView
import lotto.ui.ResultView

class LottoController(
    val inputView: InputView,
    val resultView: ResultView,
) {

    fun start() {
        val purchasingAmount = inputView.getPurchasingAmount()
        val lotto = purchaseLotto(purchasingAmount)
        val lotteryPapers = lotto.lotteryPapers
        resultView.printLottoNumbers(lotteryPapers)
    }

    private fun purchaseLotto(purchasingAmount: Int): Lotto {
        val lotto = Lotto()
        val numberOfLottoTicket = lotto.buyLottoTicket(purchasingAmount)
        resultView.printNumberOfLottoTicket(numberOfLottoTicket)
        lotto.generateLottoNumbers(numberOfLottoTicket)
        return lotto
    }
}
