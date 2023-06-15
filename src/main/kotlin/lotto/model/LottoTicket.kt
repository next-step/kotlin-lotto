package lotto.model

class LottoTicket(numbers: Set<LottoNumber>) {

    val numbers: Set<LottoNumber> = numbers.toSet()

    init {
        require(numbers.size == SIZE) {
            "lottoTicket must be $SIZE numbers. but provided numbers(`$numbers`)"
        }
    }

    infix fun matchedCountBy(other: LottoTicket): Int {
        return numbers.count { other.numbers.contains(it) }
    }

    operator fun contains(number: LottoNumber): Boolean {
        return number in numbers
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoTicket

        return numbers == other.numbers
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    override fun toString(): String {
        return "LottoTicket(numbers=$numbers)"
    }

    companion object {
        const val SIZE: Int = 6
    }
}
