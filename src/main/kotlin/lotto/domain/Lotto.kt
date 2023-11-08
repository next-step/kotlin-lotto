package lotto.domain

class Lotto(
    val numbers: List<Int>,
) {

    init {
        validateCount()
        validateNumbers()
        validateDuplication()
        numbers.sorted()
    }

    fun calculateMatchCount(other: Lotto): Int {
        return numbers.intersect(other.numbers.toSet()).size
    }

    private fun validateCount() {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다."
        }
    }

    private fun validateNumbers() {
        require(numbers.all { isValidNumber(it) }) {
            "로또 번호는 ${LOTTO_MIN_NUMBER}부터 $LOTTO_MAX_NUMBER 사이 값이어야 합니다."
        }
    }

    private fun isValidNumber(number: Int): Boolean {
        return number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER
    }

    private fun validateDuplication() {
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 중복되지 않아야 합니다."
        }
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000
    }
}
