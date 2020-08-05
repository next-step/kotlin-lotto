package lotto.model

class Buyer(private val price: Int) {

    private val _purchasedLottos = mutableListOf<Lotto>()
    val purchasedLottos: List<Lotto> get() = _purchasedLottos

    init {
        require(price >= Lotto.PRICE) {
            "로또 구매 금액이 부족합니다."
        }
    }

    fun buyLotto() {
        repeat(price / Lotto.PRICE) {
            markLotto(generateAutoLotto())
        }
    }

    fun markLotto(markedLotto: Lotto) {
        _purchasedLottos.add(markedLotto)
    }

    private fun generateAutoLotto(): Lotto {
        val autoNumbers = mutableSetOf<Int>()
        while (autoNumbers.size < Lotto.NUMBER_COUNT) {
            autoNumbers.add(Lotto.NUMBER_GENERATION_RANGE.random())
        }
        return Lotto(autoNumbers)
    }
}
