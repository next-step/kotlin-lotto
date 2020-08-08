package lotto.domain

class Lottos(private val lottos: List<Lotto>) {

    fun match(winningLotto: WinningLotto): List<Rank> {
        return lottos.map {
            val matchCount = it.countOfMatch(winningLotto)
            val matchBonus = it.contains(winningLotto.bonusNumber)
            Rank.of(matchCount, matchBonus)
        }
    }

    override fun toString(): String {
        return lottos.joinToString("\n")
    }
}
