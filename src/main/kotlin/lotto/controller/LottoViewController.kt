package lotto.controller

import lotto.model.LottoInput
import lotto.model.LottoNumbers
import lotto.model.LottoResult
import lotto.model.WinningNumbers
import lotto.component.LottoInputConverter
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoViewController(
    private val lottoInputView: LottoInputView,
    private val lottoInputConverter: LottoInputConverter,
    private val lottoResultView: LottoResultView
) {
    fun getLottoInput(): LottoInput {
        return createLottoInput()
    }

    fun printLottoResult(lottoResult: LottoResult) {
        lottoResultView.printLottoResult(lottoResult)
    }

    private fun createLottoInput(): LottoInput {
        val purchasePrice: Int = getPurchasePrice()
        val lottoNumbers: List<LottoNumbers> = getLottoNumbers(purchasePrice)
        val winningNumbers: WinningNumbers = getWinningNumbers()

        return LottoInput(lottoNumbers, winningNumbers)
    }

    private fun getPurchasePrice(): Int {
        val purchasePrice: String? = lottoInputView.getPurchasePrice()

        return lottoInputConverter.getPurchasePrice(purchasePrice)
    }

    private fun getLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        val lottoNumbers: List<LottoNumbers> = lottoInputConverter.getLottoNumbers(purchasePrice)

        lottoInputView.printPurchasedLottoNumbers(lottoNumbers)

        return lottoNumbers
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumbers: String? = lottoInputView.getWinningNumbers()

        return lottoInputConverter.getWinningNumbers(winningNumbers)
    }
}
