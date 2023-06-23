package step2Lotto.view

import java.lang.IllegalArgumentException

class InputIO {
    fun inputPurchaseAmount(inputString: String? = readlnOrNull()): Int {
        val amount = inputString?.toIntOrNull() ?: throw IllegalArgumentException(AMOUNT_IS_INSUFFICIENT)

        require(amount >= 1000) { AMOUNT_IS_INSUFFICIENT }

        return amount
    }

    fun inputWinningNumber(inputString: String? = readlnOrNull()): List<String> {
        return inputString?.replace(" ", "")?.split(",")
            ?: return listOf()
    }

    companion object {
        private const val AMOUNT_IS_INSUFFICIENT = "1000원 이상의 금액을 입력해 주세요"
    }
}
