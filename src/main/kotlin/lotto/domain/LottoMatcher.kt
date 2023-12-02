package lotto.domain

object LottoMatcher {
    fun matchAll(lottos: Lottos, winningLotto: WinningLotto): MatchedLottos {
        return lottos.matchAll(winningLotto)
    }
}
