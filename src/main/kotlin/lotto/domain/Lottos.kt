package lotto.domain

import lotto.constants.WinningRank

@JvmInline
value class Lottos(val lottos: List<Lotto>) {

    fun getLottoCount(): Int {
        return lottos.size
    }

    fun matchLotto(winningLotto: Lotto): List<WinningRank> {
        return lottos.map { LottoStore.winningRank(it, winningLotto) }
    }
}
