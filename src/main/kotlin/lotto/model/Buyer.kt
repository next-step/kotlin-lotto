package lotto.model

class Buyer {

    private val _purchasedLottos = mutableListOf<Lotto>()
    val purchasedLottos: List<Lotto> get() = _purchasedLottos

    fun buy(price: Int) {
        repeat(price / Lotto.PRICE) {
            _purchasedLottos.add(Lotto())
        }
    }
}
