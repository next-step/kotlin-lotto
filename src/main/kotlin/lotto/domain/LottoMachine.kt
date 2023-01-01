package lotto.domain

class LottoMachine(val price: Int) {

    val purchaseCount: Int

    init {
        require(price % LOTTO_BASE_PRICE == 0) { "input incorrectly price" }
        purchaseCount = price / LOTTO_BASE_PRICE
    }

    fun publishLotto(): List<Lotto> {
        return (0 until purchaseCount).map { Lotto(createNumbers()) }
    }

    private fun createNumbers(): Set<LottoNumber> {
        val shuffledNumbers = LottoNumber.RANGE.shuffled().take(6).sorted()
        return shuffledNumbers.map { LottoNumber(it) }.toSet()
    }

    companion object {
        private const val LOTTO_BASE_PRICE = 1000
    }
}
