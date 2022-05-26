package lotto.domain

typealias Lotto = List<Int>

class Seller(private val randomLottoNumberFactory: LottoNumberFactory) {
    fun sell(purchaseAmount: Int): List<Lotto> {
        val lottoCount = purchaseAmount / PRICE_OF_ONE_LOTTO

        return (1..lottoCount).map { randomLottoNumberFactory.generate() }
    }

    companion object {
        private const val PRICE_OF_ONE_LOTTO = 1000
    }
}
