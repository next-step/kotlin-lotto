package lotto.domain

import lotto.util.filterNotNull

class LottoStatistics(private val statistics: Map<Prize, Count>) : Map<Prize, Count> by statistics {

    constructor(lottos: Lottos, target: Lotto) : this(
        lottos.map { it.match(target) }
            .groupingBy { Prize.of(it) }
            .eachCount()
            .filterNotNull()
    )

    fun profit(originalBudget: Money): Money = this
        .map { (prize, count) -> (prize.money) * count }
        .sum()
        .div(originalBudget)
}
