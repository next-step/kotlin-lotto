package lotto.domain

import lotto.strategy.Strategy

class LottoMarket(private val strategy: Strategy) {
    fun buyLotto(count: Int) = getLottos(count)

    private fun getLottos(count: Int): List<Lotto> = List(count) { Lotto(strategy) }
}
