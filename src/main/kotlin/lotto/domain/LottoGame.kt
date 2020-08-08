package lotto.domain

class LottoGame(
    private val lottos: Lottos,
    private val winningLotto: WinningLotto
) {
    fun startMatch(): List<Rank> {
        return lottos.match(winningLotto)
    }
}
