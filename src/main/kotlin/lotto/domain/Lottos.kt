package lotto.domain

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {

    companion object {
        private const val PRICE = 1_000L

        fun buyRandom(budget: Money): Lottos {
            return Lottos(List(availablePurchases(budget)) { Lotto.buyRandom() })
        }

        private fun availablePurchases(budget: Money): Int = (budget / PRICE).toInt()
    }
}
