package lotto.domain

object LottoMachine {
    const val LOTTO_PRICE = 1000

    fun purchase(
        purchaseAmount: Int
    ): Lottery {
        val numberOfLotto = purchaseAmount / LOTTO_PRICE

        return Lottery(List(size = numberOfLotto) { Lotto() })
    }
}
