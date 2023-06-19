package lotto

class LottoNumber private constructor(
    val numbers: List<Int> = emptyList(),
) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 6개여야 합니다." }
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { "범위를 벗어난 숫자가 있습니다." }
        require(numbers.distinct().size == LOTTO_NUMBER_COUNT) { "중복된 숫자가 있습니다." }
    }

    fun matchCount(other: LottoNumber): Int {
        return this.numbers.count { other.numbers.contains(it) }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        val LOTTO_NUMBER_RANGE = 1..45

        fun from(numbers: List<Int>): LottoNumber {
            return LottoNumber(numbers.sorted())
        }
    }
}
