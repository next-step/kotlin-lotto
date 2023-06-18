package lotto.domain

class Lotto(
    val numbers: Set<Int> = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_COUNT).sorted().toSet(),
) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 중복되지 않는 숫자 ${LOTTO_NUMBER_COUNT}개로 구성되어야 합니다." }
        require(!hasOutOfRangeNumbers(numbers)) { "로또 번호는 ${LOTTO_NUMBER_RANGE}이어야 합니다." }
    }

    fun calculateNumberOfMatchedNumbers(numbers: Set<Int>): Int {
        return numbers.intersect(this.numbers).size
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
