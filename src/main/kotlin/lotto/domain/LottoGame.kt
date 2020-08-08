package lotto.domain

class LottoGame(private val payment: Payment) {
    private val _lottos = Lottos(LottoShop(payment).sellTickets())
    val lottos: Lottos
        get() = _lottos

    fun startMatch(winningLotto: WinningLotto): List<Rank> {
        return lottos.match(winningLotto)
    }
}
