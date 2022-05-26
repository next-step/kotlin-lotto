package lotto.domain

data class LottoTicket(val numbers: Set<Int>) {
    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBER)
    }

    companion object {
        const val SIZE_OF_LOTTO_NUMBER = 6
    }
}
