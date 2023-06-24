package step2Lotto.view

import step2Lotto.domain.dto.Lotto

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): Int {
        return inputString?.toIntOrNull() ?: 0
    }

    fun inputWinningNumber(inputString: String? = readlnOrNull()): Lotto {

        if (inputString == null) {
            return Lotto(listOf())
        }

        return Lotto(inputString.replace(" ", "").split(",").map { it.toInt() })
    }
}
