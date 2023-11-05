package lotto.domain

class Lottos(val autoLottos: List<Lotto>, val manualLottos: List<Lotto>) {

    val lottos: List<Lotto> = autoLottos + manualLottos

    fun matchLotto(winningLotto: WinningLotto): WinningRanks {
        return WinningRanks(lottos.map { it.winningRank(winningLotto) })
    }
}
