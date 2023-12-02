package lotto.domain

@JvmInline
value class LottoNumbers(private val value: List<LottoNumber>) {

    init {
        require(value.size == Lotto.NUMBERS_COUNT) {
            "로또 번호는 항상 ${Lotto.NUMBERS_COUNT}개 여야 합니다."
        }
        require(!hasDuplicate()) {
            "로또 번호는 중복이 없어야 합니다."
        }
        require(isSorted()) {
            "로또 번호는 항상 정렬되어야 합니다."
        }
    }

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

    private fun hasDuplicate(): Boolean {
        return value.distinct() != value
    }

    private fun isSorted(): Boolean {
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
