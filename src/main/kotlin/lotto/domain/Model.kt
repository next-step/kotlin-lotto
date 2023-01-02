package lotto.domain

class Lotteries(val lotteries: List<Lottery>) {
    constructor(vararg lotteries: Lottery) : this(lotteries.toList())

    fun count(): Int {
        return lotteries.size
    }
}

class Lottery(numbers: List<Int>) {

    val numbers: List<LottoNumber>

    constructor(vararg inputNumbers: Int) : this(inputNumbers.toList())

    init {
        require(numbers.size == COUNT)
        this.numbers = numbers.map { LottoNumber.of(it) }.sorted()
    }

    fun countSameLottoNumbers(other: Lottery): Int {
        return this.numbers.count { other.numbers.contains(it) }
    }
    companion object {
        const val COUNT = 6
    }
}

class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER))
    }

    override fun toString(): String {
        return "LottoNumber(number=$value)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.value.compareTo(other.value)
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private val NUMBERS = List(MAX_LOTTO_NUMBER) { LottoNumber(it + MIN_LOTTO_NUMBER) }
        fun allNumbers(): List<Int> {
            return NUMBERS.map { it.value }
        }

        fun of(number: Int): LottoNumber {
            require(number - MIN_LOTTO_NUMBER in (NUMBERS.indices))

            return NUMBERS[number - MIN_LOTTO_NUMBER]
        }
    }
}
