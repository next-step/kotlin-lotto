package lotto.domain

class Lotto(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == REQUIRED_SIZE_OF_NUMBERS) { INVALID_SIZE_OF_NUMBERS_ERROR_MSG }
        require(numbers.size == numbers.distinct().size) { DUPLICATE_NUMBER_ERROR_MSG }
    }

    fun countMatches(winningNumbers: List<LottoNumber>): Int {
        return (numbers intersect winningNumbers).size
    }

    fun checkBonusMatch(bonusNumber: LottoNumber): Boolean {
        return bonusNumber in numbers
    }

    companion object {
        val UNIT_PRICE = Money(1000)
        private const val REQUIRED_SIZE_OF_NUMBERS = 6
        private const val INVALID_SIZE_OF_NUMBERS_ERROR_MSG = "총 $REQUIRED_SIZE_OF_NUMBERS 개의 번호가 필요합니다."
        private const val DUPLICATE_NUMBER_ERROR_MSG = "번호는 중복될 수 없습니다."
    }
}
