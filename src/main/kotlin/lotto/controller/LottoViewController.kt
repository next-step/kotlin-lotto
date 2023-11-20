package lotto.controller

import lotto.component.LottoInputConverter
import lotto.model.LottoNumbers
import lotto.model.LottoResult
import lotto.model.WinningNumbers
import lotto.utils.convertToLottoNumberList
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoViewController(
    private val lottoInputView: LottoInputView,
    private val lottoInputConverter: LottoInputConverter,
    private val lottoResultView: LottoResultView
) {
    fun getPurchasePrice(): Int {
        val purchasePrice: String? = lottoInputView.getPurchasePrice()

        return lottoInputConverter.getPurchasePrice(purchasePrice)
    }

    fun getLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        return lottoInputConverter.getLottoNumbers(purchasePrice)
    }

    fun getBonusNumber(): Int {
        val bonusNumber: String? = lottoInputView.getBonusNumber()

        return lottoInputConverter.getBonusNumber(bonusNumber)
    }

    fun getWinningNumbers(): WinningNumbers {
        val winningNumbers: String? = lottoInputView.getWinningNumbers()
        return lottoInputConverter.getWinningNumbers(winningNumbers)
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoInputView.printPurchasedLottoNumbers(lottoNumbers.convertToLottoNumberList())
    }

    fun printLottoResult(lottoResult: LottoResult) {
        lottoResultView.printLottoResult(lottoResult)
    }
}
