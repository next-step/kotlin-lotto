package lotto.domain

class LottoMachine(
    private val lottoGenerator: LottoGenerator = LottoGenerator(),
) {
    fun draw(ticket: LottoTicket): Lotto =
        Lotto(ticket.manualLottoNumbers + List(ticket.autoLottoNumbersSize) { lottoGenerator.generate() })
}
