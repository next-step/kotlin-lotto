package lotto.domain

object LottoShop {
    fun purchaseLottos(purchaseAmount: Long): List<Lotto> {
        val purchaseCount = (purchaseAmount / Lotto.PRICE).toInt()

        return List(purchaseCount) { Lotto(LottoNumberGenerator.generateNumbers()) }
    }
}
