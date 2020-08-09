package lotto.model

class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    constructor(stringOfNumber: String) : this(convertTo(stringOfNumber))

    override fun toString(): String = "$number"

    override fun compareTo(other: LottoNumber): Int = this.number - other.number

    companion object {
        private val IS_NUMBER_REGEX = "(^[0-9]*\$)".toRegex()
        val NUMBER_RANGE = 1..45

        fun convertTo(stringOfNumber: String): Int {
            require(stringOfNumber.trim().matches(IS_NUMBER_REGEX)) { "숫자 이외의 값이 입력되었습니다." }

            val number = stringOfNumber.trim().toInt()
            require(NUMBER_RANGE.contains(number)) { "1 - 45 까지의 숫자만 가능합니다." }

            return number
        }
    }
}
