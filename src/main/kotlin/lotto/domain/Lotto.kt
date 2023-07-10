package lotto.domain

open class Lotto(
    val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == 6) { DUPLICATE_NUMBER_OR_NOT_SIX }
    }

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

    companion object {
        private const val DUPLICATE_NUMBER_OR_NOT_SIX = "로또 번호에 중복된 번호가 있거나 숫자의 갯수가 6개가 아닙니다."
    }
}
