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

        private fun values(): List<LottoNumber> = intRange().map { LottoNumber(it) }

        fun randomShuffle(count: Int): List<LottoNumber> {
            require(count > 0) { "count must be greater than 0 [$count]" }

            return values().shuffled().take(count).sorted()
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }

    override fun toString(): String {
        return number.toString()
    }
}

fun List<Int>.toLottoNumber(): List<LottoNumber> {
    return this.map { LottoNumber(it) }
}

fun List<LottoNumber>.toInt(): List<Int> {
    return this.map { it.number }
}