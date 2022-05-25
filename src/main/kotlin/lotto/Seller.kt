package lotto

typealias Lotto = List<Int>

class Seller(private val randomNumbersGenerator: LottoNumberFactory) {
    lateinit var lottos: List<Lotto>

    fun issueFor(purchaseAmount: Int) {
        val lottoCount = purchaseAmount / PRICE_OF_ONE_LOTTO

        lottos = (1..lottoCount).map { randomNumbersGenerator.generate() }
    }

    companion object {
        private const val PRICE_OF_ONE_LOTTO = 1000
    }
}