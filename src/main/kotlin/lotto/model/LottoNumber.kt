package lotto.model

class LottoNumber(val number: Int) {

    constructor(stringOfNumber: String) : this(convertTo(stringOfNumber))

    companion object {
        private val IS_NUMBER_REGEX = "(^[0-9]*\$)".toRegex()
        private val NUMBER_RANGE = 1..45

        fun convertTo(stringOfNumber: String): Int {
            require(stringOfNumber.matches(IS_NUMBER_REGEX)) { "숫자 이외의 값이 입력되었습니다." }

            val number = stringOfNumber.toInt()
            require(NUMBER_RANGE.contains(number)) { "1 - 45 까지의 숫자만 가능합니다." }

            return number
        }
    }
}
