package lotto.domain

class Lotto(val nums: List<Int>) {
    init {
        validateNums(nums)
    }

    private fun validateNums(numbers: List<Int>) {
        require(numbers.distinct().size == MAX_SIZE) { NUMBER_DUPLICATION_EXCEPTION_MSG }
        require(numbers.filterNot { it in NUM_RANGE }.isEmpty()) { INVALID_NUMBER_RANGE_EXCEPTION_MSG }
    }

    companion object {
        const val MAX_SIZE = 6
        val NUM_RANGE = 1..45
        private const val NUMBER_DUPLICATION_EXCEPTION_MSG = "로또 번호는 6개이며 중복된 숫자를 가질 수 없습니다."
        private const val INVALID_NUMBER_RANGE_EXCEPTION_MSG = "로또 번호는 1 ~ 45 사이의 숫자이어야 합니다."
        private fun makeRandomNums(): List<Int> = NUM_RANGE.shuffled().take(MAX_SIZE).sorted()
        fun buy(): Lotto {
            return Lotto(makeRandomNums())
        }
    }
}
