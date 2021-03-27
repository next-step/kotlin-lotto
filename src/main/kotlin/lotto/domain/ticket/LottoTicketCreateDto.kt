package lotto.domain.ticket

import lotto.domain.value.Price

data class LottoTicketCreateDto(
    val price: Price,
    val manualAmount: Int,
    val manualRequest: List<String>
) {
    init {
        require(manualRequest.size == manualAmount) { "수동 구매 요청이 잘못되었습니다. manualAmount : $manualAmount, numbers: $manualRequest" }
    }
}
