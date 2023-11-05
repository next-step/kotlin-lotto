package lotto

class LottoMachine {
    fun purchase(
        purchaseAmount: Int
    ): List<Lotto> {
        val numberOfLotto = purchaseAmount / LOTTO_PRICE

        return List(size = numberOfLotto) { Lotto() }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
