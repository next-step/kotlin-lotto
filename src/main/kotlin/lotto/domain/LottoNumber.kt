package lotto.domain

import lotto.domain.ExceptionType.INPUT_MUST_UNSIGNED_INT
import lotto.domain.ExceptionType.LAST_WEEK_NUMBERS_MUST_IN_RANGE
import lotto.domain.InputValidateChecker.isUnsignedInt

data class LottoNumber(val number: Int) {

    init {
        isNumberInRange(number)
    }

    constructor(stringValue: String) : this(stringValue.toValidatedUnsignedInt())

    operator fun compareTo(other: LottoNumber): Int = compareValuesBy(this, other, LottoNumber::number)

    private fun isNumberInRange(number: Int) {
        require(numberRange.contains(number)) { LAST_WEEK_NUMBERS_MUST_IN_RANGE }
    }

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = 45
        private val numberRange = (MIN_VALUE..MAX_VALUE)

        fun String.toValidatedUnsignedInt(): Int {
            require(isUnsignedInt(this)) { INPUT_MUST_UNSIGNED_INT }
            return this.toInt()
        }
    }
}
