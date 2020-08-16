package lotto.domain.selling

import lotto.domain.lotto.LottoTicket

data class Payment(
    val money: Int,
    val manualCount: Int = 0,
    val manualLottoTickets: List<LottoTicket> = listOf()
) {

    init {
        require(manualCount * Seller.LOTTO_PRICE <= money) { "처음 지불한 금액 이상의 로또를 발급받을 수 없습니다" }
    }

    companion object {

        fun isValidManualCount(manualCount: Int, money: Int) = manualCount * Seller.LOTTO_PRICE <= money
    }
}
