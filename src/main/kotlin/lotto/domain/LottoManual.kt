package lotto.domain

@JvmInline
value class ManualLottoCount(val value: Int) {
    init {
        require(value >= 0) { "로또 수는 항상 0이상이에요. given: $value" }
    }
}

class ManualLottos(val lottos: LottoTickets) {
    constructor(manualNumbers: List<List<Int>>) : this(
        LottoTickets(
            manualNumbers.map(::LottoTicket)
        )
    )
}
