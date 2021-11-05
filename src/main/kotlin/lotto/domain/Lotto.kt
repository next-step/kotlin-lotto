package lotto.domain

class Lotto(val numbers: List<Int>) {

    init {
        require(numbers.size == REQUIRED_SIZE_OF_NUMBERS) { INVALID_SIZE_OF_NUMBERS_ERROR_MSG }
        require(numbers.size == numbers.distinct().size) { DUPLICATE_NUMBER_ERROR_MSG }
    }

    fun countMatches(winningNumbers: List<Int>): Int {
        return (numbers intersect winningNumbers).size
    }

    companion object {
        private const val REQUIRED_SIZE_OF_NUMBERS = 6
        private const val INVALID_SIZE_OF_NUMBERS_ERROR_MSG = "총 $REQUIRED_SIZE_OF_NUMBERS 개의 번호가 필요합니다."
        private const val DUPLICATE_NUMBER_ERROR_MSG = "번호는 중복될 수 없습니다."
    }
}
