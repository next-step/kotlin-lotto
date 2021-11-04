package lotto.model

class LottoShop {

    fun buy(amount: Amount): List<Lotto> {
        val size = amount / LOTTO_PRICE
        val machine = LottoMachine()
        return machine.auto(Size(size), LOTTO_PRICE)
    }

    fun buy(amount: Amount, manualNumbers: List<LottoNumbers>): List<Lotto> {
        val size = amount / LOTTO_PRICE
        val manualSize = manualNumbers.size.coerceAtMost(size)
        val autoSize = size - manualSize

        val machine = LottoMachine()
        val manual = machine.manual(manualNumbers.take(manualSize), LOTTO_PRICE)
        val auto = machine.auto(Size(autoSize), LOTTO_PRICE)

        return manual + auto
    }

    companion object {
        private val LOTTO_PRICE = Price(1_000)
    }
}
