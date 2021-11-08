package lotto.model

class LottoShop {

    private val machine = LottoMachine()

    fun buy(amount: Amount): List<Lotto> {
        val size = amount / LOTTO_PRICE
        return machine.auto(Size.valueOf(size), LOTTO_PRICE)
    }

    fun buy(amount: Amount, manualNumbers: List<LottoNumbers>): List<Lotto> {
        val size = amount / LOTTO_PRICE
        val manualSize = manualNumbers.size.coerceAtMost(size)
        val autoSize = size - manualSize

        val manual = machine.manual(manualNumbers.take(manualSize), LOTTO_PRICE)
        val auto = machine.auto(Size.valueOf(autoSize), LOTTO_PRICE)

        return manual + auto
    }

    companion object {
        private val LOTTO_PRICE = Price.valueOf(1_000)
    }
}
