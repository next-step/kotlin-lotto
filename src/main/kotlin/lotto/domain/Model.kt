package lotto.domain

data class Lotteries(val lotteries: List<Lottery>) {
    constructor(vararg lotteries: Lottery) : this(lotteries.toList())

    fun count(): Int {
        return lotteries.size
    }
}

class Lottery(numbers: List<LottoNumber>) {
    private val numbers: List<LottoNumber>

    constructor(vararg inputNumbers: Int) : this(inputNumbers.map { LottoNumber.of(it) }.toList())

    init {
        require(numbers.size == 6)
        this.numbers = numbers.sorted()
    }

    fun countSameLottoNumbers(other: Lottery): Int {
        return this.numbers.count { other.numbers.contains(it) }
    }

    fun getLottoNumbers(): List<Int> {
        return numbers.map { it.value }.toList()
    }
}

class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in (1..45))
    }

    companion object {
        private val NUMBERS = List(45) { LottoNumber(it + 1) }

        fun allNumbers(): List<LottoNumber> {
            return NUMBERS
        }

        fun of(number: Int): LottoNumber {
            require(number - 1 in (NUMBERS.indices))

            return NUMBERS[number - 1]
        }
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
}
