package lotto

object LottoNumberValidator {
    const val LOTTO_MIN_RANGE = 1
    const val LOTTO_MAX_RANGE = 45
    private const val LOTTO_NUMBER_SIZE = 6

    fun validateNumbers(numbers: Set<Int>) {
        validateSize(numbers)
        validateNumberRange(numbers)
    }

    fun validateSize(numbers: Set<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 6개여야 합니다. 현재 전달된 개수는 ${numbers.size}개 입니다." }
    }

    fun validateNumberRange(numbers: Set<Int>) {
        require(numbers.all { isInRange(it) }) { "로또 번호는 ${LOTTO_MIN_RANGE}~${LOTTO_MAX_RANGE} 내의 숫자여야 합니다." }
    }

    private fun isInRange(number: Int) = number in IntRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE)
}
