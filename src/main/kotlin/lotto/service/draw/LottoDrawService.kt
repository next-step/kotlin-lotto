package lotto.service.draw

import lotto.domain.Prize
import lotto.domain.WinningStatistic

object LottoDrawService {
    fun draw(spec: LottoDrawSpec): WinningStatistic {
        val prizes = spec.lottos.mapNotNull {
            val matchedNumberCount = it.getMatchedNumberCount(spec.winningNumbers)
            Prize.valueOfOrNull(matchedNumberCount)
        }

        return WinningStatistic(
            prizes = prizes,
            purchaseAmount = spec.purchaseAmount,
        )
    }
}
