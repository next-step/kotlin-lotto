package lotto.domain

class LottoTicket(numbers: List<Int>? = null) {
    private val lottoNumbers = numbers ?: (1..45).shuffled().take(6).sorted()

    init {
        validateNumbers(lottoNumbers)
    }

    fun numbers(): List<Int> {
        return lottoNumbers
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers().intersect(winningNumbers.toSet()).size
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다."
        private const val LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1부터 45까지만 가능합니다."
        private const val LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "로또 번호는 중복되지 않아야 합니다."

        fun validateNumbers(numbers: List<Int>) {
            require(numbers.size == 6) { LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE }
            require(numbers.all { it in 1..45 }) { LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE }
            require(numbers.toSet().size == 6) { LOTTO_NUMBER_DUPLICATE_EXCEPTION_MESSAGE }
        }
    }
}
