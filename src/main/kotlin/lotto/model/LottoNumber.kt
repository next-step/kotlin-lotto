package lotto.model

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in 1..45) { "로또 번호는 1애서 45 사이의 자연수입니다!" }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val NUMBERS_MAXIMUM = 45
    }

    override fun compareTo(other: LottoNumber): Int {
        return number - other.number
    }
}
