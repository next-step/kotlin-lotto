package lotto

class DefaultNumbers private constructor(
    val numbers: List<Int>,
) {
    init {
        require(numbers.size == DEFAULT_LOTTO_NUMBER_COUNT) { "기본 로또 번호는 6개여야 합니다." }
        require(numbers.distinct().size == DEFAULT_LOTTO_NUMBER_COUNT) { "중복된 숫자가 있습니다." }
    }

    fun countMatch(other: DefaultNumbers): Int {
        return this.numbers.count { other.numbers.contains(it) }
    }

    companion object {
        const val DEFAULT_LOTTO_NUMBER_COUNT = 6

        fun from(numbers: List<Int>): DefaultNumbers {
            return DefaultNumbers(numbers.sorted())
        }
    }
}
