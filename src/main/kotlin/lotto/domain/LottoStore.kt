package lotto.domain

import lotto.domain.util.LotteryTicketAutoGenerator

class LottoStore {

    fun purchase(request: LotteryTicketsOrderRequest): PurchaseLotteryTicketResult {
        return try {
            validate(request)
            val totalAutoPurchaseAmount = request.purchaseAmount - (request.getManualLotteryTicketQuantity() * PURCHASE_AMOUNT_UNIT)
            val autoLotteryTickets = makeAutoLotteryTickets(ticketCount = totalAutoPurchaseAmount / PURCHASE_AMOUNT_UNIT)
            val manualLotteryTickets = makeManualLotteryTickets(request.manualLottoNumbers)
            val purchasedLotteryTickets = LotteryTickets(lotteryTickets = autoLotteryTickets + manualLotteryTickets)
            PurchaseLotteryTicketResult.SUCCESS(
                lotteryTickets = purchasedLotteryTickets,
                manualLotteryTicketQuantity = manualLotteryTickets.size,
                autoLotteryTicketQuantity = autoLotteryTickets.size,
            )
        } catch (exception: Exception) {
            PurchaseLotteryTicketResult.FAIL(exception = exception)
        }
    }

    private fun makeAutoLotteryTickets(ticketCount: Int): LotteryTickets = LotteryTickets(
        (1..ticketCount).map { LotteryTicketAutoGenerator.generateAuto() },
    )

    private fun makeManualLotteryTickets(manualLottoNumbers: List<LottoNumbers>): LotteryTickets {
        val lotteryTickets = manualLottoNumbers.map { LotteryTicket(lottoNumbers = it, isAuto = false) }
        return LotteryTickets(lotteryTickets = lotteryTickets)
    }

    private fun validate(request: LotteryTicketsOrderRequest) {
        require(request.purchaseAmount % PURCHASE_AMOUNT_UNIT == 0) { "로또 구매 금액 단위는 1000원입니다." }
        require(request.purchaseAmount >= MIN_PURCHASE_AMOUNT) { "로또 최소 구매 금액은 1000원입니다. " }
        require(request.purchaseAmount >= request.getManualLotteryTicketQuantity() * PURCHASE_AMOUNT_UNIT) {
            "수동 구매 금액이 구입금액보다 클 수 없습니다."
        }
    }

    companion object {
        private const val MIN_PURCHASE_AMOUNT = 1000
        const val PURCHASE_AMOUNT_UNIT = 1000
    }
}
