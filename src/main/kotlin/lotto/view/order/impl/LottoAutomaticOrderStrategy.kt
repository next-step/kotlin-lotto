package lotto.view.order.impl

import lotto.model.LottoGame
import lotto.model.strategy.LottoNumbersRandomStrategy
import lotto.view.order.LottoOrderStrategy

object LottoAutomaticOrderStrategy : LottoOrderStrategy {
    override fun issue(count: Int): List<LottoGame> {
        return (1..count)
            .asSequence()
            .map { _ -> LottoGame(LottoNumbersRandomStrategy.pick()) }
            .toList()
    }
}
