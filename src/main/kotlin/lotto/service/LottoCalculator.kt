package lotto.service

import lotto.domain.Rank

object LottoCalculator {
    fun calculatePrizeMoney(rank: Rank): Long = rank.winningMoney
}
