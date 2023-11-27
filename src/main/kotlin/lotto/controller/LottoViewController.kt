package lotto.controller

import lotto.component.LottoInputValidator
import lotto.model.*
import lotto.view.LottoInputView
import lotto.view.LottoResultView

class LottoViewController(
    private val lottoInputView: LottoInputView,
    private val lottoInputValidator: LottoInputValidator,
    private val lottoResultView: LottoResultView
) {
    fun getPurchasePrice(): PurchasePrice {
        val purchasePrice: String? = lottoInputView.getPurchasePrice()

        return convertPurchasePrice(purchasePrice)
    }

    fun getManualLottoNumbersCount(): Int {
        val manualLottoNumbersCount = lottoInputView.getManualLottoNumbersCount()

        return convertManualLottoNumbersCount(manualLottoNumbersCount)
    }

    fun getManualLottoNumbers(manualLottoNumbersCount: Int, purchasePrice: PurchasePrice): Pair<List<LottoNumbers>, PurchasePrice> {
        val manualLottoPurchasePrice = PurchasePrice.getLottoTotalPrice(manualLottoNumbersCount)
            .run { PurchasePrice(this) }
            .run { lottoInputValidator.validateLottoOverbuy(this, purchasePrice) }

        val extraPurchasePrice = purchasePrice - manualLottoPurchasePrice
        val manualLottoNumbers: List<LottoNumbers> = List(manualLottoNumbersCount) {
            lottoInputView
                .getManualLottoNumbers()
                .run { convertLottoNumbers(this) }
        }

        return Pair(manualLottoNumbers, extraPurchasePrice)
    }

    fun getLottoNumbers(purchasePrice: PurchasePrice): List<LottoNumbers> {
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

    private fun convertPurchasePrice(purchasePrice: String?): PurchasePrice {
        return purchasePrice
            .run { lottoInputValidator.validatePurchasePrice(this) }
            .toInt()
            .run { PurchasePrice(this) }
    }

    private fun convertManualLottoNumbersCount(manualLottoNumbersCount: String?): Int {
        return lottoInputValidator
            .validateManualLottoNumbersCount(manualLottoNumbersCount)
            .toInt()
    }

    private fun convertLottoNumbers(lottoNumbers: String?): LottoNumbers {
        val numbers = convertLottoNumbersStringToIntList(lottoNumbers)

        return LottoNumbers.create(numbers)
    }

    private fun convertLottoNumbers(purchasePrice: PurchasePrice): List<LottoNumbers> {
        val count: Int = PurchasePrice.purchaseLottoCount(purchasePrice)
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
        val numbers = convertLottoNumbersStringToIntList(winningNumbers)

        return WinningNumbers.create(numbers)
    }

    private fun convertLottoNumbersStringToIntList(lottoNumbers: String?): List<Int> {
        return lottoNumbers
            .run { lottoInputValidator.validateLottoNumbers(this) }
            .split(LOTTO_NUMBERS_SEPARATOR)
            .map { lottoInputValidator.validateLottoNumber(it) }
            .map { it.toInt() }
            .run { lottoInputValidator.validateLottoNumberCount(this) }
    }

    fun printPurchasedLottoNumbers(manualLottoNumbers: List<LottoNumbers>, lottoNumbers: List<LottoNumbers>) {
        lottoInputView.printPurchasedLottoNumbers(
            manualLottoNumbers.convertToLottoNumberList(),
            lottoNumbers.convertToLottoNumberList()
        )
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
