package lotto.statistics

import lotto.Lottos
import lotto.rank.LottoRank

class WinningStatistics(
    val ranks: List<LottoRank>,
) {
    constructor(purchasedLottos: Lottos, winningNumbers: List<Int>) :
        this(purchasedLottos.lottos.map { it.getRank(winningNumbers) })
}
