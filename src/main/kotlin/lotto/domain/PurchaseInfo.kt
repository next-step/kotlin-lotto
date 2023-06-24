package lotto.domain

class PurchaseInfo(private val paidPrice: Int, val manualLottos: List<List<LottoNumber>>) {
    init {
        require(paidPrice > 0) { "지불한 가격은 항상 양수여야 합니다." }
        require(paidPrice > manualLottos.size * LOTTO_PRICE) { "지불한 금액보다 더 많은 로또를 구입할 수 없습니다." }
    }

    fun manualLottoCount() = manualLottos.size

    fun autoLottoCount(): Int {
        val autoLottoPrice = paidPrice - manualLottoCount() * LOTTO_PRICE
        return autoLottoPrice / LOTTO_PRICE
    }

    fun totalLottosPrice() = (manualLottoCount() + autoLottoCount()) * LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
