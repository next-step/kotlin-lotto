package lottery.domain

data class Lottos(val lottos: List<Lotto>) {
    fun matchLottos(winningLotto: WinningLotto): List<Rank> {
        return lottos.map { Rank.of(winningLotto.getMatchResult(it), winningLotto.getBonusMatchResult(it)) }
    }
}
