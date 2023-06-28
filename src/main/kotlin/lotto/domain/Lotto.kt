package lotto.domain

open class Lotto(
    val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == 6)
    }

    constructor(numbers: Array<Int>) : this(numbers.map { LottoNumber(it) }.toSet())
    constructor(numbers: List<LottoNumber>) : this(numbers.map { it }.toSet())

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        return numbers.containsAll(other.numbers)
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }
}
