package lotto.model

class LottoMachine(private val amount: Int, private val selfNumbers: List<Set<Int>> = emptyList()) {

    init {
        require((amount) >= LOTTO_PRICE) {
            "구매 금액은 $LOTTO_PRICE 원 이상이어야 합니다."
        }
    }

    private val numbersOfAutoLotto: Int
        get() = (amount - selfPrice) / LOTTO_PRICE

    private val selfPrice: Int
        get() = (selfNumbers.count() * LOTTO_PRICE)

    private fun createSelfLotto() = selfNumbers.map {
        Lotto.create(it)
    }

    private fun createAutoLotto(count: Int): List<Lotto> {
        return List(count) {
            Lotto.create()
        }
    }

    fun buyLotto(): List<Lotto> {

        val count = numbersOfAutoLotto
        val selfLotto = createSelfLotto()
        val autoLotto = createAutoLotto(count)

        return selfLotto + autoLotto
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
