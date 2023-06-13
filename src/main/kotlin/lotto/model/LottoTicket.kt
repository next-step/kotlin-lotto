package lotto.model

class LottoTicket(numbers: Set<LottoNumber>) {

    val numbers: Set<LottoNumber> = numbers.toSortedSet()

    init {
        require(numbers.size == SIZE) {
            "lottoTicket must be $SIZE numbers. but provided numbers(`$numbers`)"
        }
    }

    infix fun matchedCount(other: LottoTicket): Int {
        return numbers.count { other.numbers.contains(it) }
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
