package lotto

class LottoTicket(lottoTicket: List<Lotto>) {
    private val lottoTicket: MutableList<Lotto> = lottoTicket.toMutableList()

    operator fun plus(lottoTicket: List<Lotto>) {
        this.lottoTicket.addAll(lottoTicket)
    }
}
