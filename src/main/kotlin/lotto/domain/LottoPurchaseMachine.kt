package lotto.domain

object LottoPurchaseMachine {
    const val LOTTO_PRICE = 1000
    fun getLottos(purchasePrice: Int): List<Lotto> {
        val numberOfLotto = calculateNumberOfLotto(purchasePrice)
        return generateLottos(numberOfLotto)
    }

    private fun calculateNumberOfLotto(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
    }

    private fun generateLottos(count: Int): List<Lotto> {
        return (1..count).map { RandomLottoFactory.generate() }
    }
}
