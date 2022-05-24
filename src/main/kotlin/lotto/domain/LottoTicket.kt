package lotto.domain

data class LottoTicket(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
