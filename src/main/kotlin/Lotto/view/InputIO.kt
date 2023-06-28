package Lotto.view

import Lotto.domain.LottoNumber
import Lotto.domain.WinningNumber

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): Int {
        return inputString?.toIntOrNull() ?: 0
    }

    fun inputWinningNumber(inputString: String? = readlnOrNull()): WinningNumber {

        if (inputString == null) {
            return WinningNumber(listOf())
        }

        return WinningNumber(convertStringToIntArray(inputString))
    }

    private fun convertStringToIntArray(string: String): List<LottoNumber> {
        return string.replace(" ", "")
            .split(",")
            .map { LottoNumber(it.toInt()) }
    }
}
