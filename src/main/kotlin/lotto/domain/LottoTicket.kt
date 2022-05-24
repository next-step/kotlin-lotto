package lotto.domain

data class LottoTicket(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6)
    }
}
