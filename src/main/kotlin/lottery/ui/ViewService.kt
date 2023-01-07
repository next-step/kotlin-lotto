package lottery.ui

import lottery.domain.lotto.Lotto
import lottery.domain.winningresult.WinningResult

class ViewService(
    private val inputView: InputView,
    private val resultView: ResultView,
) {

    fun getPurchasingAmount(): Long {
        return inputView.getPurchasingAmount()
    }

    fun getWinningNumber(): List<Int> {
        return inputView.getWinningNumber()
    }

    fun showPurchasingResult(lottos: List<Lotto>) {
        return resultView.showPurchasingResult(lottos)
    }

    fun showResultOfWinning(result: WinningResult) {
        return resultView.showResultOfWinning(result)
    }

    fun showRateOfReturn(rateOfReturn: String) {
        return resultView.showRateOfReturn(rateOfReturn)
    }
}
