package step2Lotto.view

import step2Lotto.domain.LottoNumber
import step2Lotto.domain.Lotto

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): Int {
        return inputString?.toIntOrNull() ?: 0
    }

    fun inputWinningNumber(inputString: String? = readlnOrNull()): Lotto {

        if (inputString == null) {
            return Lotto(listOf())
        }

        return Lotto(convertStringToLottoNumbers(inputString))
    }

    private fun convertStringToLottoNumbers(string: String): List<LottoNumber> {
        return string.replace(" ", "")
            .split(",")
            .map { LottoNumber(it.toInt()) }
    }
}
