package lotto.domain

/**
 * 입력 받은 금액 만큼의 로또를 돌려준다.
 */
class LottoPurchaser(
    private val lottoSeller: LottoSeller,
    lottos: List<Lotto> = emptyList()
) {

    private val purchasedLottos: MutableList<Lotto> = lottos.toMutableList()

    fun purchase(inputAmount: Int): List<Lotto> {
        val purchaseAmount = getPurchasableNum(inputAmount)
        val purchasedLotto = lottoSeller.sell(purchaseAmount)
        purchasedLottos.addAll(purchasedLotto)
        return purchasedLottos.toList()
    }

    private fun getPurchasableNum(inputAmount: Int): Int {
        return inputAmount / Lotto.PRICE
    }
}
