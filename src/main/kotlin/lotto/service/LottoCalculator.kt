package lotto.service

import lotto.domain.Lotto

class LottoCalculator {
    companion object {
        fun countMatch(lotto: Lotto, winningLotto: Lotto): Int {
            return lotto.numbers
                .intersect(winningLotto.numbers)
                .size
        }
    }
}
