package lotto.domain

object LottoPurchaseMachine {
    const val LOTTO_PRICE = 1000
    fun getLottos(purchasePrice: Int, manualLottos: List<Lotto>): List<Lotto> {
        val autoLottoPurchasePrice = calculateAutoLottoPurchasePrice(purchasePrice, manualLottos.size)
        val numberOfAutoLotto = calculateNumberOfLotto(autoLottoPurchasePrice)
        val autoLottos = generateAutoLottos(numberOfAutoLotto)
        return autoLottos + manualLottos
    }

    private fun calculateAutoLottoPurchasePrice(purchasePrice: Int, numberOfManualLotto: Int): Int {
        val result = purchasePrice - numberOfManualLotto * LOTTO_PRICE
        require(result >= 0) { "지불한 금액보다 더 많은 로또를 구입할 수 없습니다." }
        return result
    }

    private fun calculateNumberOfLotto(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_PRICE
    }

    private fun generateAutoLottos(count: Int): List<Lotto> {
        return (1..count).map { RandomLottoFactory.generate() }
    }
}
