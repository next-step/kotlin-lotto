package lotto.domain

class LottoBundle(private var _lottos: MutableList<Lotto> = mutableListOf()) {

    val lottos
        get() = _lottos.toList()

    fun addAll(lottos: List<Lotto>) {
        _lottos.addAll(lottos)
    }

    fun matchWinningLotto(winningLotto: WinningLotto): Report {
        val ranks = lottos.map { winningLotto.compareWith(it) }
        return Report(Ranks(ranks))
    }
}
