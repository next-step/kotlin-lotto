package lotto.domain

class Lottos(private val autoLottos: List<Lotto>, private val manualLottos: List<Lotto>) {

    val lottos: List<Lotto> get() = autoLottos + manualLottos

    fun matchLotto(winningLotto: WinningLotto): WinningRanks {
        return WinningRanks(lottos.map { it.winningRank(winningLotto) })
    }
    fun manualLottoCount(): Int {
        return manualLottos.size
    }
    fun autoLottoCount(): Int {
        return autoLottos.size
    }
}
