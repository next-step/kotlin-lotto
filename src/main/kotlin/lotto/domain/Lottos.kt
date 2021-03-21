package lotto.domain

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {

    fun matchAll(target: Lotto) = LottoResult(
        map { it.match(target) }
    )

    companion object {
        private const val PRICE = 1000

        fun buyRandom(price: Int): Lottos {
            return Lottos(List(price / PRICE) { Lotto.buyRandom() })
        }
    }
}
