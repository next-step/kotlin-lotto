package lotto

typealias Lotto = List<Int>

class Seller(private val randomNumbersGenerator: LottoNumberFactory) {
    fun sell(purchaseAmount: Int): List<Lotto> {
        val lottoCount = purchaseAmount / PRICE_OF_ONE_LOTTO

        return (1..lottoCount).map { randomNumbersGenerator.generate() }
    }

    companion object {
        private const val PRICE_OF_ONE_LOTTO = 1000
    }
}