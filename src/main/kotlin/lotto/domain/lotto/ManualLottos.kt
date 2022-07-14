package lotto.domain.lotto

class ManualLottos(val lottos: LottoTickets) {
    constructor(manualNumbers: List<List<Int>>) : this(
        LottoTickets(
            manualNumbers.map(::LottoTicket)
        )
    )

    fun count(): Int {
        return lottos.lottoTickets.size
    }
}
