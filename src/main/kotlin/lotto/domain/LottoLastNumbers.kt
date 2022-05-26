package lotto.domain

data class LottoLastNumbers(private val tickets: LottoTicket, val bonus: Int) : Set<Int> by tickets.numbers {

    constructor(numbers: Set<Int>, bonus: Int) : this(LottoTicket(numbers), bonus)

    init {
        require(bonus in LottoTicket.RANGE_OF_LOTTO_NUMBER)
        require(tickets.numbers.contains(bonus).not())
    }
}
