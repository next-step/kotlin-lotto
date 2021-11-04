package lotto.model

class LottoShop {

    fun buy(amount: Int): List<Lotto> {
        require(amount >= 0)

        val size = amount / LOTTO_PRICE
        val machine = LottoMachine()
        return machine.auto(Size.from(size), LOTTO_PRICE)
    }

    fun buy(amount: Int, manualNumbers: List<LottoNumbers>): List<Lotto> {
        require(amount >= 0)

        val size = amount / LOTTO_PRICE
        val manualSize = manualNumbers.size.coerceAtMost(size)
        val autoSize = size - manualSize

        val machine = LottoMachine()
        val manual = machine.manual(manualNumbers.take(manualSize), LOTTO_PRICE)
        val auto = machine.auto(Size.from(autoSize), LOTTO_PRICE)

        return manual + auto
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
