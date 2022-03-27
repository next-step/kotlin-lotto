package lotto.domain

class Lottos(private val lottos: List<Lotto>) {

    fun matchAll(target: Lotto) = LottoResult(
        originalPrice = originalPrice(),
        matchResult = lottos.map { it.match(target) }
    )

    fun size() = lottos.size

    fun forEach(action: (Lotto) -> Unit) {
        for (element in lottos) action(element)
    }

    private fun originalPrice() = size() * PRICE

    companion object {
        private const val PRICE = 1000

        fun buyRandom(price: Int): Lottos {
            return Lottos(List(price / PRICE) { Lotto.buyRandom() })
        }
    }
}
