package lotto.domain

class LottoNumbers(val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 $LOTTO_NUMBER_COUNT 개이어야 합니다" }
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { "로또 번호는 $LOTTO_MIN_NUMBER 부터 $LOTTO_MAX_NUMBER 사이어야 합니다" }
    }

    fun countMatchedNumber(other: LottoNumbers): Int {
        return (numbers intersect other.numbers).size
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        private val LOTTO_NUMBER_RANGE = LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER

        fun create(): LottoNumbers {
            val numbers = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_COUNT).sorted().toSet()
            return LottoNumbers(numbers)
        }
    }
}
