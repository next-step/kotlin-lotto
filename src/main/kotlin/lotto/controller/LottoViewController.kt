package lotto.controller

import lotto.component.LottoInputConverter
import lotto.model.LottoNumbers
import lotto.model.LottoResult
import lotto.model.WinningNumbers
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
        val lottoNumbers: List<LottoNumbers> = lottoInputConverter.getLottoNumbers(purchasePrice)

        lottoInputView.printPurchasedLottoNumbers(lottoNumbers)

        return lottoNumbers
    }

    fun getWinningNumbers(): WinningNumbers {
        val winningNumbers: String? = lottoInputView.getWinningNumbers()
        return lottoInputConverter.getWinningNumbers(winningNumbers)

    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoInputView.printPurchasedLottoNumbers(lottoNumbers)
    }

    fun printLottoResult(lottoResult: LottoResult) {
        lottoResultView.printLottoResult(lottoResult)
    }
}
