package lotto.domain.selling

import lotto.domain.lotto.LottoTicket

data class Payment(
    val money: Int,
    val manualCount: Int = 0,
    val manualLottoTickets: List<LottoTicket> = listOf()
) {

    init {
        require(isValidManualCount(manualCount, money)) { "처음 지불한 금액보다 많이 구매할 수 없습니다." }
    }

    companion object {

        fun isValidManualCount(manualCount: Int, money: Int) = manualCount * Seller.LOTTO_PRICE <= money
    }
}
