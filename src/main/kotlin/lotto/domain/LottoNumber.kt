package lotto.domain

import lotto.Const

data class LottoNumber(
    private val value: Int
) : Comparable<LottoNumber> {
    init {
        require(value in MIN_LOTTO_NUM..MAX_LOTTO_NUM) { Const.ErrorMsg.CANNOT_CONVERSE_LOTTO_NUMBER_ERROR_MSG }
    }

    override fun toString(): String = value.toString()

    override fun equals(other: Any?): Boolean =
        when (other) {
            is LottoNumber -> value == other.value
            is Int -> value == other
            else -> false
        }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override operator fun compareTo(other: LottoNumber): Int = this.value.compareTo(other.value)

    companion object {
        const val MIN_LOTTO_NUM = 1
        const val MAX_LOTTO_NUM = 45
    }
}
