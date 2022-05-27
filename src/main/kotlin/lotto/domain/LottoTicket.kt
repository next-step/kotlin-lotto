package lotto.domain

data class LottoTicket(val numbers: Set<Int>) {

    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBER)
    }

    companion object {
        private const val MIN_RANGE_OF_NUMBER = 1
        private const val MAX_RANGE_OF_NUMBER = 45
        const val SIZE_OF_LOTTO_NUMBER = 6
        val RANGE_OF_LOTTO_NUMBER = MIN_RANGE_OF_NUMBER..MAX_RANGE_OF_NUMBER
    }
}
