package stringAddCalculator.number

import stringAddCalculator.ErrorCode

class PositiveNumber(private val tempValue: Any) : Number {
    override val value: Int

    init {
        if (!validation()) throw RuntimeException(ErrorCode.NOT_POSITIVE_NUMBER_ERROR.msg)
        value = tempValue as Int
    }

    override fun validation(): Boolean {
        return Integer.signum(tempValue as Int) == POSITIVE_NUMBER_RESULT
    }

    companion object {
        const val POSITIVE_NUMBER_RESULT = 1
    }
}
