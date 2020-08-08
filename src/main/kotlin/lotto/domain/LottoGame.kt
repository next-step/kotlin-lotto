package lotto.domain

class LottoGame(private val payment: Payment) {
    private val _lottos = Lottos(LottoShop(payment).sellTickets())
    val lottos: Lottos
        get() = _lottos

    fun startMatch(winningNumbers: Lotto, bonusNumber : LottoNumber): List<Rank> {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        return lottos.match(winningLotto)
    }
}
