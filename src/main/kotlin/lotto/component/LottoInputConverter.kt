package lotto.component

import lotto.model.LottoNumbers
import lotto.model.WinningNumbers

class LottoInputConverter(
    private val lottoInputValidator: LottoInputValidator
) {
    fun getPurchasePrice(purchasePrice: String?): Int {
        return purchasePrice.run { lottoInputValidator.validatePurchasePrice(this) }
            .toInt()
    }

    fun getLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        val lottoNumbersCount: Int = lottoInputValidator.validateLottoNumbersCount(purchasePrice / Lotto.LOTTO_PRICE)

        return LottoNumbersGenerator.generate(lottoNumbersCount)
    }

    fun getWinningNumbers(winningNumbers: String?): WinningNumbers {
        val numbers = winningNumbers
            .run { lottoInputValidator.validateLottoNumbers(this) }
            .split(LOTTO_NUMBERS_SEPARATOR)
            .map { lottoInputValidator.validateLottoNumber(it) }
            .map { it.toInt() }
            .run { lottoInputValidator.validateLottoNumberCount(this) }

        return WinningNumbers.create(numbers)
    }

    companion object {
        const val LOTTO_NUMBERS_SEPARATOR = ", "
    }
}
