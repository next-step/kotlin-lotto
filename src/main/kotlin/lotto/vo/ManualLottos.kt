package lotto.vo

class ManualLottos(private val price: Long, private val buyCount: Long) {
    val manualLotto: List<ManualLotto> = createManualLottoList(price)

    private fun createManualLottoList(price: Long): List<ManualLotto> {
        val availableCountForPurchase = price / LOTTO_PRICE_PER_ONE
        require(availableCountForPurchase < Int.MAX_VALUE) { "로또 구매 개수는 ${Int.MAX_VALUE}개를 넘을 수 없습니다." }
        require(availableCountForPurchase >= 0) { "가격은 음수가 될 수 없습니다." }
        require(this.buyCount <= availableCountForPurchase) { "수동으로 구매할 로또 수는 전체 로또 수보다 클 수 없습니다." }
        return (LOTTO_COUNT_START..buyCount).map { ManualLotto() }
    }

    companion object {
        private const val LOTTO_PRICE_PER_ONE = 1000L
        private const val LOTTO_COUNT_START = 1L
    }
}
