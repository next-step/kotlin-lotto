package lotto.model

class LottoShop {

    fun buyLotto(amount: Int): List<Lotto> {
        require(amount >= 0)

        val size = amount / LOTTO_PRICE
        val machine = LottoMachine()
        return machine.createLotto(size)
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
