package lotto.domain

class LotteryTicketsOrderRequest(
        val purchaseAmount: Int,
        val manualLottoNumbers: List<LottoNumbers> = emptyList()
) {

    fun getManualLotteryTicketQuantity(): Int = manualLottoNumbers.size
}
