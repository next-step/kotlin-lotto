package lotto.domain

/**
 * 입력 받은 금액 만큼의 로또를 돌려준다.
 */
class LottoPurchaser(
    private val request: LottoPurchaseRequest
) {

    private val purchasedLottos = mutableListOf<Lotto>()

    fun purchase(): List<Lotto> {
        val manualLotto = LottoSeller.sellManualLotto(request.manualNumbers)
        purchasedLottos.addAll(manualLotto)

        val autoLotto = LottoSeller.sellAutoLotto(request.autoAmount)
        purchasedLottos.addAll(autoLotto)

        return purchasedLottos.toList()
    }
}
