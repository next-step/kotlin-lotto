package lotto.domain

import lotto.domain.ExceptionType.INPUT_MUST_UNSIGNED_INT
import lotto.domain.ExceptionType.LAST_WEEK_NUMBERS_MUST_IN_RANGE
import lotto.domain.InputValidateChecker.isUnsignedInt

data class LottoNumber(val number: Int) {

    init {
        isNumberInRange(number)
    }
    operator fun compareTo(other: LottoNumber): Int = compareValuesBy(this, other, LottoNumber::number)

    constructor(stringValue: String) : this(stringValue.toValidatedUnsignedInt())

    private fun isNumberInRange(number: Int) {
        require(numberRange.contains(number)) { LAST_WEEK_NUMBERS_MUST_IN_RANGE }
    }

    companion object {
        fun String.toValidatedUnsignedInt(): Int {
            require(isUnsignedInt(this)) { INPUT_MUST_UNSIGNED_INT }
            return this.toInt()
        }

        private val numberRange = (1..45)
    }
}
