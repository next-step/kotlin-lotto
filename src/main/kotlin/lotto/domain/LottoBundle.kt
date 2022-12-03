package lotto.domain

class LottoBundle(private var _lottos: MutableList<Lotto> = mutableListOf(), private val report: Report = Report()) {

    val lottos
        get() = _lottos.toList()

    fun addAll(lottos: List<Lotto>) {
        _lottos.addAll(lottos)
    }

    fun matchWinningLotto(winningLotto: WinningLotto): Report {
        lottos.map { winningLotto.compareWith(it, report) }
        return report
    }
}
