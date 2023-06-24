package step2Lotto.view

import step2Lotto.domain.dto.Lotto
import java.lang.IllegalArgumentException

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): Int {
        val amount = inputString?.toIntOrNull() ?: throw IllegalArgumentException(AMOUNT_IS_INSUFFICIENT)

        require(amount >= 1000) { AMOUNT_IS_INSUFFICIENT }

        return amount
    }

    fun inputWinningNumber(inputString: String? = readlnOrNull()): Lotto {

        if (inputString == null) {
            return Lotto(listOf())
        }

        return Lotto(inputString.replace(" ", "").split(",").map { it.toInt() })
    }

    companion object {
        private const val AMOUNT_IS_INSUFFICIENT = "1000원 이상의 금액을 입력해 주세요"
    }
}
