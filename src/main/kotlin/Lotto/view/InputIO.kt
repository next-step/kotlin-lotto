package Lotto.view

import Lotto.domain.LottoNumber
import Lotto.domain.WinningLotto

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): Int {
        return inputString?.toIntOrNull() ?: 0
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
