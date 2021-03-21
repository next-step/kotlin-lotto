package lotto.domain

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {

    companion object {
        private const val PRICE = 1000

        fun buyRandom(price: Int): Lottos {
            return Lottos(List(price / PRICE) { Lotto.buyRandom() })
        }
    }
}
