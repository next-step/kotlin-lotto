package lotto

class LottoMachine(val price: Int) {

    val purchaseCount: Int

    init {
        require(price % Const.LOTTO_BASE_PRICE == 0) { "input incorrectly price" }
        purchaseCount = price / Const.LOTTO_BASE_PRICE
    }

    fun publishLotto(): List<Lotto> {
        return (0 until purchaseCount).map { Lotto(createNumbers()) }
    }

    private fun createNumbers(): List<Int> {
        return (Const.LOTTO_MIN_RANDOM_VALUE..Const.LOTTO_MAX_RANDOM_VALUE).shuffled().take(6).sorted()
    }
}
