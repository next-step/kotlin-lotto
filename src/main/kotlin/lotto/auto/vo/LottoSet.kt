package lotto.auto.vo

import lotto.auto.domain.Lotto

class LottoSet(private val lottos: List<Lotto>) {

    fun countPlace(winningLottery: Lotto, place: LottoScore): Int =
        lottos.count { it.match(winningLottery) == place }
}
