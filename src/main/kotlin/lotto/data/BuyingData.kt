package lotto.data

import lotto.domain.maker.LotteryTicketMaker

data class BuyingData(
    val inputPrice: Int,
    val manualNumbersList: List<LottoNumbers>
) {
    val manualTicketCount
        get() = manualNumbersList.size
    val autoTicketCount
        get() = inputPrice / LotteryTicketMaker.LOTTERY_TICKET_PRICE - manualNumbersList.size
}
