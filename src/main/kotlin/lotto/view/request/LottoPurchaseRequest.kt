package lotto.view.request

import lotto.domain.ticket.LottoTicketCreateDto
import lotto.domain.value.Price

data class LottoPurchaseRequest(
    val price: Price,
    val manualNumberRequest: ManualNumberRequest
) {
    data class ManualNumberRequest(
        val amount: Int,
        val numbers: List<String>
    )

    fun toCreateDto(): LottoTicketCreateDto {
        return LottoTicketCreateDto(
            price = price,
            manualAmount = manualNumberRequest.amount,
            manualRequest = manualNumberRequest.numbers
        )
    }
}
