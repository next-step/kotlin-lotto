package lotto.domain.lotto.number

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {

    init {
        require(number in intRange()) {
            "Lotto number must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER"
        }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1

        const val MAX_LOTTO_NUMBER = 45

        private fun intRange(): IntRange = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)

        fun values(): List<LottoNumber> = intRange().map { LottoNumber(it) }
    }

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }

    override fun toString(): String {
        return number.toString()
    }
}
