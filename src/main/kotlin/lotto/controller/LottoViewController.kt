package lotto.controller

import lotto.component.Lotto
import lotto.component.LottoInputValidator
import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.LottoResult
import lotto.model.WinningNumbers
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoViewController(
    private val lottoInputView: LottoInputView,
    private val lottoInputValidator: LottoInputValidator,
    private val lottoResultView: LottoResultView
) {
    fun getPurchasePrice(): Int {
        val purchasePrice: String? = lottoInputView.getPurchasePrice()

        return convertPurchasePrice(purchasePrice)
    }

    fun getLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        return convertLottoNumbers(purchasePrice)
    }

    fun getBonusNumber(winningNumbers: WinningNumbers): LottoNumber {
        val bonusNumber: String? = lottoInputView.getBonusNumber()

        return convertBonusNumber(bonusNumber, winningNumbers)
    }

    fun getWinningNumbers(): WinningNumbers {
        val winningNumbers: String? = lottoInputView.getWinningNumbers()

        return convertWinningNumbers(winningNumbers)
    }

    private fun convertPurchasePrice(purchasePrice: String?): Int {
        return purchasePrice
            .run { lottoInputValidator.validatePurchasePrice(this) }
            .toInt()
    }

    private fun convertLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        val count: Int = Lotto.purchaseLottoCount(purchasePrice)
        val lottoNumbersCount: Int = lottoInputValidator.validateLottoNumbersCount(count)

        return LottoNumbers.generate(lottoNumbersCount)
    }

    private fun convertBonusNumber(bonusNumber: String?, winningNumbers: WinningNumbers): LottoNumber {
        val number: LottoNumber = lottoInputValidator
            .validateLottoNumber(bonusNumber)
            .toInt()
            .run { LottoNumber.from(this) }

        return lottoInputValidator.validateBonusNumber(number, winningNumbers)
    }

    private fun convertWinningNumbers(winningNumbers: String?): WinningNumbers {
        val numbers = winningNumbers
            .run { lottoInputValidator.validateLottoNumbers(this) }
            .split(LOTTO_NUMBERS_SEPARATOR)
            .map { lottoInputValidator.validateLottoNumber(it) }
            .map { it.toInt() }
            .run { lottoInputValidator.validateLottoNumberCount(this) }

        return WinningNumbers.create(numbers)
    }

    fun printPurchasedLottoNumbers(lottoNumbers: List<LottoNumbers>) {
        lottoInputView.printPurchasedLottoNumbers(lottoNumbers.convertToLottoNumberList())
    }

    private fun List<LottoNumbers>.convertToLottoNumberList(): List<List<Int>> {
        return map { it.numbers.convertToIntList() }
    }

    private fun List<LottoNumber>.convertToIntList(): List<Int> {
        return map { it.number }
    }

    fun printLottoResult(lottoResult: LottoResult) {
        lottoResultView.printLottoResult(lottoResult)
    }

    companion object {
        const val LOTTO_NUMBERS_SEPARATOR = ", "
    }
}
