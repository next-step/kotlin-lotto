package step2Lotto.domain

open class Lotto(
    val numbers: List<LottoNumber>
) {
    init {
        check(numbers.size == 6)
        check(numbers.size == numbers.toSet().size)
    }

    constructor(numbers: Array<Int>) : this(numbers.map { LottoNumber(it) })

    fun getLottoNumbers(): List<Int> {
        return numbers.map { it.value }
    }

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
