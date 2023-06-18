package lotto.model

class LottoMachine(private val amount: Int) {

    init {
        require((amount) >= LOTTO_PRICE) {
            "구매 금액은 $LOTTO_PRICE 원 이상이어야 합니다."
        }
    }

    fun buyLotto(): List<Lotto> {
        val count = numbersOfLotto()
        return List(count) {
            Lotto.create()
        }
    }

    private fun numbersOfLotto() = amount / LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
