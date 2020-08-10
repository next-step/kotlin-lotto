package lotto.domain

class LottoGame(private val lottos: Lottos) {

    fun startMatch(winningNumbers: Lotto, bonusNumber: LottoNumber): List<Rank> {
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        return lottos.match(winningLotto)
    }
}
