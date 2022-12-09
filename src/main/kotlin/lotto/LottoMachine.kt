package lotto

class LottoMachine(val price: Int) {

    val purchaseCount: Int

    init {
        require(price % LOTTO_BASE_PRICE == 0) { "input incorrectly price" }
        purchaseCount = price / LOTTO_BASE_PRICE
    }

    fun publishLotto(): List<Lotto> {
        return (0 until purchaseCount).map { Lotto(createNumbers()) }
    }

    private fun createNumbers(): List<LottoNumber> {
        val shuffledNumbers = (LOTTO_MIN_RANDOM_VALUE..LOTTO_MAX_RANDOM_VALUE).shuffled().take(6).sorted()
        return shuffledNumbers.map { LottoNumber(it) }
    }

    companion object {
        private const val LOTTO_BASE_PRICE = 1000
        private const val LOTTO_MIN_RANDOM_VALUE = 1
        private const val LOTTO_MAX_RANDOM_VALUE = 45
    }
}
