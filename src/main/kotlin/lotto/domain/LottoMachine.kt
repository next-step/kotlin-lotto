package lotto.domain

object LottoMachine {
    private const val LOTTO_PRICE = 1000
    fun getLottos(purchasePrice: Int): List<Lotto> {
        val numberOfLotto = calculateNumberOfLotto(purchasePrice)
        return (1..numberOfLotto).map { LottoFactory.generateRandom() }
    }

    private fun calculateNumberOfLotto(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
    }
}
