package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.ManualLottoCount
import lotto.domain.PurchaseAmount

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): PurchaseAmount {
        return try {
            PurchaseAmount(inputString?.toIntOrNull() ?: 0)
        } catch (e: IllegalArgumentException) {
            this.inputPurchaseAmount()
        }
    }

    fun inputManualLottoCount(inputString: String? = readlnOrNull()): ManualLottoCount {
        return try {
            ManualLottoCount(inputString?.toIntOrNull() ?: 0)
        } catch (e: IllegalArgumentException) {
            this.inputManualLottoCount()
        }
    }

    fun inputWinningNumber(inputString: String? = readlnOrNull()): List<LottoNumber> {

        if (inputString == null) {
            return listOf()
        }

        return convertStringToLottoNumbers(inputString)
    }

    private fun convertStringToLottoNumbers(string: String): List<LottoNumber> {
        return string.replace(" ", "")
            .split(",")
            .map { LottoNumber(it.toInt()) }
    }

    fun inputBonusNumber(inputString: String? = readlnOrNull()): LottoNumber {
        return LottoNumber(inputString?.toIntOrNull() ?: 0)
    }
}
