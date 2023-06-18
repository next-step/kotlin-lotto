package lotto.domain

class Lotto(
    val numbers: Set<Int> = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_COUNT).sorted().toSet(),
) {
    init {
        validateLengthOfNumbers(numbers)
        validateRangeOfNumbers(numbers)
    }

    fun calculateResult(numbers: Set<Int>): LottoRank {
        return LottoRank.of(numbers.intersect(this.numbers).size)
    }

    private fun validateLengthOfNumbers(numbers: Set<Int>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복되지 않는 숫자 ${LOTTO_NUMBER_COUNT}개로 구성되어야 합니다." }
    }

    private fun validateRangeOfNumbers(numbers: Set<Int>) {
        require(!hasOutOfRangeNumbers(numbers)) { "로또 번호는 ${LOTTO_NUMBER_RANGE}이어야 합니다." }
    }

    private fun hasOutOfRangeNumbers(numbers: Set<Int>): Boolean {
        return numbers.any { number ->
            number !in LOTTO_NUMBER_RANGE
        }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
        const val PRICE = 1000
    }
}
