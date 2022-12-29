package lotto.domain

class LottoBundle(
    private var _manualLottos: MutableList<Lotto> = mutableListOf(),
    private var _autoLottos: MutableList<Lotto> = mutableListOf()
) {

    val manualCount
        get() = _manualLottos.size

    val autoCount
        get() = _autoLottos.size
    val lottos
        get() = _manualLottos.toList() + _autoLottos.toList()

    fun addManualLottos(lottos: List<Lotto>) {
        _manualLottos.addAll(lottos)
    }

    fun addAutoLottos(lottos: List<Lotto>) {
        _autoLottos.addAll(lottos)
    }

    fun matchWinningLotto(winningLotto: WinningLotto): Report {
        val ranks = lottos.map { winningLotto.compareWith(it) }
        return Report(Ranks(ranks))
    }
}
