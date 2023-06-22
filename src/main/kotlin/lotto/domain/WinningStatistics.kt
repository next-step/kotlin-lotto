package lotto.domain

import lotto.service.LottoCalculator

class WinningStatistics(winningStatistics: Map<Int, Int>) {

    companion object {
        fun of(lottos: Lottos, winningLotto: Lotto): Map<Int, Int> {
            return lottos.lottos
                .map { lotto -> LottoCalculator.countMatch(lotto, winningLotto) }
                .groupBy { it }
                .mapValues { it.value.size }
        }
    }
}
