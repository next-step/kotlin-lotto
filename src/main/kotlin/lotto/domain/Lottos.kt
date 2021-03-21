package lotto.domain

class Lottos(private val lottos: List<Lotto>) : List<Lotto> by lottos {

    fun matchAll(target: Lotto) = LottoResult(
        originalPrice = originalPrice(),
        matchResult = map { it.match(target) }
    )

    private fun originalPrice() = this.size * PRICE

    companion object {
        private const val PRICE = 1000

        fun buyRandom(price: Int): Lottos {
            return Lottos(List(price / PRICE) { Lotto.buyRandom() })
        }
    }
}
