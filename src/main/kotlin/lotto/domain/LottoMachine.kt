package lotto.domain

object LottoMachine {
    const val LOTTO_PRICE = 1000

    fun purchase(
        purchaseAmount: Int
    ): List<Lotto> {
        val numberOfLotto = purchaseAmount / LOTTO_PRICE

        return List(size = numberOfLotto) { Lotto() }
    }
}
