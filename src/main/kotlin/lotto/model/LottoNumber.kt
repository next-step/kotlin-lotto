package lotto.model

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in NUMBERS_MINIMUM..NUMBERS_MAXIMUM) { "로또 번호는 $NUMBERS_MINIMUM 애서 $NUMBERS_MAXIMUM 사이의 자연수입니다!" }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val NUMBERS_MAXIMUM = 45
        const val NUMBERS_MINIMUM = 1
    }

    override fun compareTo(other: LottoNumber): Int {
        return number - other.number
    }
}
