package lotto

object LottoPolicy {
    private const val FIRST_LOTTO_NUMBER = 1
    private const val LAST_LOTTO_NUMBER = 45
    private const val LOTTO_NUMBERS_SIZE = 6

    val LOTTO_NUMBER_RANGE = FIRST_LOTTO_NUMBER..LAST_LOTTO_NUMBER
    const val LOTTO_PRICE = 1_000

    fun validateBonusNumber(number: Int) {
        require(number in LOTTO_NUMBER_RANGE) {
            throw IllegalArgumentException("로또 번호는 ${FIRST_LOTTO_NUMBER}이상, $LAST_LOTTO_NUMBER 이하 숫자 입니다 - `$number")
        }
    }

    fun validateLottoNumberCount(number: Int) {
        require(number == LOTTO_NUMBERS_SIZE) {
            throw IllegalArgumentException("로또 번호는 ${LOTTO_NUMBERS_SIZE}개 입니다. (현재 : $number)")
        }
    }

    fun validateDuplicatedNumber(numbers: List<Int>) {
        require(isDistinctNumber(numbers)) {
            val duplicatedNumbers = getDuplicatedNumbers(numbers)
            throw IllegalArgumentException("중복된 번호가 입력됐습니다. $duplicatedNumbers")
        }
    }

    private fun isDistinctNumber(numbers: List<Int>): Boolean {
        return numbers.size == numbers.toSet().size
    }

    private fun getDuplicatedNumbers(numbers: List<Int>): List<Int> {
        return numbers - numbers.toSet()
    }
}
