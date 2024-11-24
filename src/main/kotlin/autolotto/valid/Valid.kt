package autolotto.valid

import kotlin.math.sign

object Valid {
    private const val NEGATIVE_EXCEPTION_MESSAGE = "양수만 입력 가능합니다."
    private const val LOTTO_AMOUNT = 1000
    private const val REMAINDER_EXCEPTION_MESSAGE = "돈은 1000원 단위만 입력가능합니다."
    private const val MIN_AMOUNT_EXCEPTION_MESSAGE = "로또는 최소 1장 이상 구매해야합니다."

    fun stringToInt(target: String): Int {
        try {
            return Integer.parseInt(target)
        } catch (nex: NumberFormatException) {
            throw NumberFormatException("$target 은 숫자로 변환 하는데 실패했습니다.")
        }
    }

    fun inputNumberValid(target: Int): Int {
        validateNegative(target)
        return positiveNumber(target)
    }

    private fun positiveNumber(target: Int): Int {
        require(target >= 0) { "$target 은 양수가 아닙니다." }
        return target
    }

    private fun validateNegative(convertedNumber: Int) {
        when {
            convertedNumber and Int.MIN_VALUE != 0 -> throw RuntimeException(
                NEGATIVE_EXCEPTION_MESSAGE,
            )

            convertedNumber.sign < 0 -> throw RuntimeException(NEGATIVE_EXCEPTION_MESSAGE)
            convertedNumber < 0 -> throw RuntimeException(NEGATIVE_EXCEPTION_MESSAGE)
        }
    }

    fun purchaseAmountValid(amount: Int) {
        if (amount < LOTTO_AMOUNT) throw RuntimeException(MIN_AMOUNT_EXCEPTION_MESSAGE)
        val remainder = amount % LOTTO_AMOUNT
        if (remainder != 0) throw RuntimeException(REMAINDER_EXCEPTION_MESSAGE)
    }
}
