package lotto.model

class LottoShop {

    fun buy(amount: Int): List<Lotto> {
        require(amount >= 0)

        val size = amount / LOTTO_PRICE
        val machine = LottoMachine()
        return machine.auto(size, LOTTO_PRICE)
    }

    fun buy(amount: Int, manualNumbers: List<LottoNumbers>): List<Lotto> {
        require(amount >= 0)

        val size = amount / LOTTO_PRICE
        val manualSize = manualNumbers.size.coerceAtMost(size)
        val machine = LottoMachine()

        return machine.manual(manualNumbers.take(manualSize), LOTTO_PRICE)
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
