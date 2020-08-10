package lotto.domain

class Lottos(private val _lottos: List<Lotto>) {
    val lottos: List<Lotto>
        get() = _lottos

    fun match(winningLotto: WinningLotto): List<Rank> {
        return lottos.map {
            val matchCount = it.countOfMatch(winningLotto)
            val matchBonus = it.contains(winningLotto.bonusNumber)
            Rank.of(matchCount, matchBonus)
        }
    }

    fun size() = _lottos.size

    override fun toString(): String {
        return lottos.joinToString("\n")
    }
}
