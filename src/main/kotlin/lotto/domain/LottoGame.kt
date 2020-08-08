package lotto.domain

class LottoGame(payment: Payment) {
    private val _lottos = Lottos(LottoShop(payment).sellTickets())
    val lottos: Lottos
        get() = _lottos
    lateinit var winningLotto: WinningLotto

    fun startMatch(): List<Rank> {
        return lottos.match(winningLotto)
    }
}
