package lotto.domain

data class Lotteries(val lotteries: List<Lottery>) {
    fun count(): Int {
        return lotteries.size
    }
}

class Lottery(numbers: List<LottoNumber>) {
    val numbers: List<LottoNumber>

    init {
        require(numbers.size == 6)
        this.numbers = numbers.sorted()
    }
}

class LottoNumber private constructor(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in (1..45))
    }

    companion object {
        private val NUMBERS = List(45) { LottoNumber(it + 1) }

        fun allNumbers(): List<LottoNumber> {
            return NUMBERS
        }

        fun getInstance(number: Int): LottoNumber {
            require(number - 1 in (NUMBERS.indices))

            return NUMBERS[number - 1]
        }
    }

    override fun toString(): String {
        return "LottoNumber(number=$number)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number.compareTo(other.number)
    }
}
