package lotto.model

class Buyer {

    private val _purchasedLottos = mutableListOf<Lotto>()
    val purchasedLottos: List<Lotto> get() = _purchasedLottos

    fun buyLotto(price: Int) {
        require(price >= Lotto.PRICE) {
            "로또 구매 금액이 부족합니다."
        }

        repeat(price / Lotto.PRICE) {
            markLotto(generateAutoLottoNumber())
        }
    }

    fun markLotto(markingNumber: List<Int>) {
        _purchasedLottos.add(Lotto(markingNumber))
    }

    private fun generateAutoLottoNumber(): List<Int> {
        val autoNumbers = mutableListOf<Int>()
        repeat(Lotto.NUMBER_COUNT) {
            autoNumbers.add(Lotto.NUMBER_GENERATION_RANGE.random())
        }
        return autoNumbers
    }
}
