package lotto.domain

class LottoBundle(private var _lottos: MutableList<Lotto> = mutableListOf()) {

    val lottos
        get() = _lottos.toList()

    fun addAll(lottos: List<Lotto>) {
        _lottos.addAll(lottos)
    }

    fun matchWinningLotto(winningLotto: WinningLotto): Report {
        val ranks = lottos.map { winningLotto.compareWith(it) }
        val firstCount = ranks.count { it == Rank.FIRST }
        val secondCount = ranks.count { it == Rank.SECOND }
        val thirdCount = ranks.count { it == Rank.THIRD }
        val fourthCount = ranks.count { it == Rank.FOURTH }
        val fifthCount = ranks.count { it == Rank.FIFTH }
        val missCount = ranks.count { it == Rank.MISS }
        return Report(
            firstCount = firstCount,
            secondCount = secondCount,
            thirdCount = thirdCount,
            fourthCount = fourthCount,
            fifthCount = fifthCount,
            missCount = missCount
        )
    }
}
