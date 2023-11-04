package lotto.domain

import lotto.constants.WinningRank

class Lottos(val autoLottos: List<Lotto>, val manualLottos: List<Lotto>) {

    val lottos: List<Lotto> = autoLottos + manualLottos

    fun matchLotto(winningLotto: WinningLotto): List<WinningRank> {
        return lottos.map { it.winningRank(winningLotto) }
    }
}
