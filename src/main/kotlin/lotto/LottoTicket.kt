package lotto

data class LottoTicket(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
}
