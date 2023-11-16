package lotto.component

import lotto.model.LottoInput
import lotto.model.LottoNumbers
import lotto.model.LottoResult
import lotto.model.WinningNumbers
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoViewController(
    private val lottoInputView: LottoInputView,
    private val lottoInputFactory: LottoInputFactory,
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
        val purchasePrice: String? = lottoInputView.getInput("구입 금액을 입력해주세요.")

        return lottoInputFactory.getPurchasePrice(purchasePrice)
    }

    private fun getLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        val lottoNumbers: List<LottoNumbers> = lottoInputFactory.getLottoNumbers(purchasePrice)

        lottoInputView.printPurchasedLottoNumbers(lottoNumbers)

        return lottoNumbers
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumbers: String? = lottoInputView.getInput("지난 주 당첨 번호를 입력해 주세요.")

        return lottoInputFactory.getWinningNumbers(winningNumbers)
    }
}
