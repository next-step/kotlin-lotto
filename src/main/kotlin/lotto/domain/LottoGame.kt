package lotto.domain

class LottoGame(lottoShop: LottoShop) {
    private val _lottos = Lottos(lottoShop.sellTickets())
    val lottos: Lottos
        get() = _lottos

    fun startMatch(winningNumbers: Lotto, bonusNumber: LottoNumber): List<Rank> {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        return lottos.match(winningLotto)
    }
}
