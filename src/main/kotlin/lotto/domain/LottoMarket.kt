package lotto.domain

import lotto.strategy.Strategy

class LottoMarket(private val customer: Customer, private val strategy: Strategy) {
    fun buyLotto(customer: Customer) = getLottos(customer.count)

    private fun getLottos(count: Int): List<Lotto> = List(count) { Lotto(strategy) }
}
