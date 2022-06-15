package lotto.dto

import lotto.domain.LottoRank
import lotto.domain.Money

data class WinningStatDto(val lottoRank: LottoRank, val totalWinningCount: Int) {
    val totalWinningPrize: Money = Money(lottoRank.wonPrize.value * totalWinningCount)
}
