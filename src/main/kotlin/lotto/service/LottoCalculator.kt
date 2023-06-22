package lotto.service

import lotto.domain.Lotto

class LottoCalculator {
    companion object {
        fun countMatch(lotto: Lotto, winningLotto: Lotto): Int {
            return lotto.numbers
                .intersect(winningLotto.numbers)
                .size
        }

        fun calculatePrizeMoney(matchCount: Int): Int {
            return when (matchCount) {
                3 -> 5_000
                4 -> 50_000
                5 -> 1_500_000
                6 -> 2_000_000_000
                else -> 0
            }
        }
    }
}
