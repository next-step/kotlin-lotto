package lotto.statistics

import lotto.Lottos
import lotto.rank.LottoRank

class WinningStatistics(
    val ranks: List<LottoRank>,
) {
    constructor(purchasedLottos: Lottos, winningNumber: WinningNumber) :
        this(purchasedLottos.lottos.map { it.getRank(winningNumber) })
}
