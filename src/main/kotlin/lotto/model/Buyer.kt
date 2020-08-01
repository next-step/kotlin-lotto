package lotto.model

class Buyer {

    private val _purchasedLottos = mutableListOf<Lotto>()
    val purchasedLottos: List<Lotto> get() = _purchasedLottos

    fun buy(price: Int) {
        require(price >= Lotto.PRICE) {
            "로또 구매 금액이 부족합니다."
        }

        repeat(price / Lotto.PRICE) {
            _purchasedLottos.add(Lotto())
        }
    }
}
