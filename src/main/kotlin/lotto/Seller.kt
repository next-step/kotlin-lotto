package lotto

class Seller(private val randomNumbersGenerator: IRandomNumberGenerator) {
    lateinit var lottos: List<List<Int>>

    fun issueFor(purchaseAmount: Int) {
        val lottoCount = purchaseAmount / PRICE_OF_ONE_LOTTO

        lottos = (1..lottoCount).map { randomNumbersGenerator.generate() }
    }

    companion object {
        private const val PRICE_OF_ONE_LOTTO = 1000
    }
}