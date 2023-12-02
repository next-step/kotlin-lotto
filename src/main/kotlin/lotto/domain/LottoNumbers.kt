package lotto.domain

@JvmInline
value class LottoNumbers(private val value: List<LottoNumber>) {
    val size: Int
        get() = value.size

    val numbers: List<Int>
        get() = value.map { it.value }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return value.contains(lottoNumber)
    }

    fun containsCount(other: LottoNumbers): Int {
        return value.count { other.value.contains(it) }
    }

    fun hasDuplicate(): Boolean {
        return value.distinct() != value
    }

    fun isSorted(): Boolean {
        return value.map { it.value }
            .zipWithNext { a, b -> a <= b }
            .all { it }
    }

    companion object {
        fun of(numbers: List<Int>): LottoNumbers {
            val lottoNumbers = numbers.map { LottoNumber(it) }

            return LottoNumbers(lottoNumbers)
        }
    }
}
