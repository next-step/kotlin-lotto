package next.step.lotto.domain

object LottoStore {

    const val LOTTO_PRICE: Int = 1000

    fun buy(payment: Int): Int {
        require(canBuy(payment)) { "로또 가격을 지불해야 합니다." }
        return payment - LOTTO_PRICE
    }

    fun canBuy(payment: Int): Boolean = payment >= LOTTO_PRICE

    fun preview(algorithm: LottoNumberGenerationAlgorithm): Lotto = Lotto.of(algorithm())
}