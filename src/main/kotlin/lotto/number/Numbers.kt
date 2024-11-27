package lotto.number

data class Numbers(
    val numbers: List<LottoNumber>,
) {
    fun hasNumber(number: LottoNumber): Boolean = numbers.contains(number)

    fun countMatching(other: Numbers): Int = other.numbers.count { this.hasNumber(it) }

    companion object {
        fun List<LottoNumber>.sorted(): List<LottoNumber> = this.sortedBy { it.number }

        fun fromInts(ints: List<Int>): Numbers = Numbers(ints.map { LottoNumber(it) })
    }
}
