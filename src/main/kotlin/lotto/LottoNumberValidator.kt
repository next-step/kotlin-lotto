package lotto

object LottoNumberValidator {
    val LOTTO_RANGE = 1..45
    private const val LOTTO_NUMBER_SIZE = 6

    fun validateNumbers(numbers: Set<Int>) {
        validateSize(numbers)
        validateNumberRange(numbers)
    }

    private fun validateSize(numbers: Set<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "로또 번호는 6개여야 합니다. 현재 전달된 개수는 ${numbers.size}개 입니다." }
    }

    private fun validateNumberRange(numbers: Set<Int>) {
        require(numbers.all { isInRange(it) }) { "로또 번호는 ${LOTTO_RANGE.first} ~ ${LOTTO_RANGE.last} 내의 숫자여야 합니다." }
    }

    private fun isInRange(number: Int) = number in LOTTO_RANGE
}
