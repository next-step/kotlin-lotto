package lotto.domain

data class LottoLastNumbers(private val tickets: LottoTicket, val bonus: LottoNumber) : Set<LottoNumber> by tickets {

    init {
        require(contains(bonus).not())
    }

    constructor(numbers: Set<Int>, bonus: Int) :
            this(LottoTicket.ManualLottoTicket(numbers.toLottoNumber()), LottoNumber(bonus))
}
