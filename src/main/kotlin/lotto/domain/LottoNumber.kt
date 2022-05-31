package lotto.domain

class LottoNumber private constructor(val number: Int) : Comparable<LottoNumber> {

    override fun toString(): String = number.toString()

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }

    companion object {
        private const val MIN_RANGE_OF_NUMBER = 1
        private const val MAX_RANGE_OF_NUMBER = 45
        private val RANGE_OF_LOTTO_NUMBER = MIN_RANGE_OF_NUMBER..MAX_RANGE_OF_NUMBER
        private val cache: Map<Int, LottoNumber> = RANGE_OF_LOTTO_NUMBER.map { it }.associateWith(::LottoNumber)

        fun from(number: Int): LottoNumber {
            require(number in RANGE_OF_LOTTO_NUMBER)
            return cache[number] ?: throw IllegalArgumentException()
        }

        fun shuffled(): List<LottoNumber> = cache.values.shuffled()
    }
}

fun Int.toLottoNumber(): LottoNumber = LottoNumber.from(this)
fun Set<Int>.toLottoNumber(): Set<LottoNumber> = map { it.toLottoNumber() }.toSet()
