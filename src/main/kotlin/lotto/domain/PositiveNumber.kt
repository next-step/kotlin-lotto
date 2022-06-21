package lotto.domain

import lotto.Const

@JvmInline
value class PositiveNumber(
    private val number: Int
) {
    init {
        require(number >= 0) { "0이상이 아닌 값이 들어있습니다." }
    }

    fun toInt() = number

    override fun toString(): String {
        return number.toString()
    }

    operator fun compareTo(lottoCount: PositiveNumber): Int =
        number.compareTo(lottoCount.number)

    operator fun minus(lottoCount: PositiveNumber): PositiveNumber =
        PositiveNumber(number.minus(lottoCount.number))

    companion object {
        fun of(value: String): PositiveNumber {
            val result = requireNotNull(value.toIntOrNull()) { Const.ErrorMsg.INPUT_VALUE_IS_NOT_INT_ERROR_MSG }
            return PositiveNumber(result)
        }
    }
}
