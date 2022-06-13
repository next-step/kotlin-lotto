package lotto.domain

@JvmInline
value class LottoNumbers(private val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) { "중복되지 않는 6개의 숫자가 있어야합니다." }
    }

    fun matchCount(lotto: LottoNumbers): Int = lotto.numbers.intersect(numbers.toSet()).size

    operator fun contains(lotto: LottoNumber): Boolean = lotto in numbers

    override fun toString(): String {
        return numbers.joinToString(", ") { it.number.toString() }
    }
}
