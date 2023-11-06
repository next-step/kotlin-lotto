package lotto

object LottoMachine {
    fun purchase(
        purchaseAmount: Int
    ): List<Lotto> {
        val numberOfLotto = purchaseAmount / LOTTO_PRICE

        return List(size = numberOfLotto) { Lotto() }
    }

    const val LOTTO_PRICE = 1000
}
