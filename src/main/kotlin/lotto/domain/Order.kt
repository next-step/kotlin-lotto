package lotto.domain

import lotto.LottoShop.Companion.UNIT_OF_AMOUNT

data class Order(
    val amount: Int,
    val autoLottos: List<Lotto>,
    val manualLottos: List<Lotto> = listOf(),
) {
    init {
        validateLottoCounts()
    }

    private fun validateLottoCounts() {
        val count = amount / UNIT_OF_AMOUNT
        require(autoLottos.size + manualLottos.size == count) { "구매한 금액과 로또의 수량이 일치하지 않습니다." }
    }
}
