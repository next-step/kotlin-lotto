package lotto.service

import lotto.component.Lotto
import lotto.component.LottoInputValidator
import lotto.component.LottoNumbersGenerator
import lotto.model.LottoNumbers
import lotto.model.WinningNumbers

class LottoInputService(
    private val lottoInputValidator: LottoInputValidator,
    private val lottoNumbersGenerator: LottoNumbersGenerator
) {
    fun getPurchasePrice(purchasePrice: String?): Int {
        return purchasePrice.run { lottoInputValidator.validatePurchasePrice(this) }
            .toInt()
    }

    fun getLottoNumbers(purchasePrice: Int): List<LottoNumbers> {
        val lottoNumbersCount: Int = lottoInputValidator.validateLottoNumbersCount(purchasePrice / Lotto.LOTTO_PRICE)

        return lottoNumbersGenerator.generate(lottoNumbersCount)
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
