package lotto.domain

data class LottoLastNumbers(private val tickets: LottoTicket, val bonus: Int) : Set<Int> by tickets {

    init {
        require(bonus in LottoTicket.RANGE_OF_LOTTO_NUMBER)
        require(contains(bonus).not())
    }

    constructor(numbers: Set<Int>, bonus: Int) : this(LottoTicket(numbers), bonus)
}
