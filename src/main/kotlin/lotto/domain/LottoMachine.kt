package lotto.domain

class LottoMachine(val price: Int, val manualLottos: ManualLottos) {

    val purchaseCount: Int
    val autoCount: Int
    val autoLottos: List<Lotto>

    init {
        require(price % LOTTO_BASE_PRICE == 0) { "input incorrectly price" }
        purchaseCount = price / LOTTO_BASE_PRICE
        autoCount = purchaseCount - manualLottos.manualLottos.size
        autoLottos = (0 until autoCount).map { Lotto(createNumbers()) }
    }

    fun publishLotto(): List<Lotto> {
        return manualLottos.manualLottos + autoLottos
    }

    private fun createNumbers(): Set<LottoNumber> {
        val shuffledNumbers = LottoNumber.RANGE.shuffled().take(6).sorted()
        return shuffledNumbers.map { LottoNumber(it) }.toSet()
    }

    companion object {
        private const val LOTTO_BASE_PRICE = 1000
    }
}
