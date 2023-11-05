package lotto

class LottoMachine {
    private val lottoNumberPool = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        .toList()
    fun purchase(
        purchaseAmount: Int
    ): List<Lotto> {
        val numberOfLotto = purchaseAmount / LOTTO_PRICE

        return List(size = numberOfLotto) { Lotto(createRandomNumbers()) }
    }

    private fun createRandomNumbers() = lottoNumberPool
        .shuffled()
        .subList(0, 6)

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_PRICE = 1000
    }
}
