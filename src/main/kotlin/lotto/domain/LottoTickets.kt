package lotto.domain

class LottoTickets(
    lottoPurchaseInfo: LottoPurchaseInfo,
    manualNumbers: List<Set<Int>>,
) {
    val manualTickets: List<LottoTicket> = getManualTickets(manualNumbers)

    val autoTickets: List<LottoTicket> = getAutoTickets(lottoPurchaseInfo)

    val tickets = manualTickets + autoTickets

    val totalTicketPrice = tickets.size * LOTTO_PRICE

    private fun getManualTickets(manualNumbers: List<Set<Int>>): List<LottoTicket> {
        return manualNumbers.map { LottoTicket(it) }
    }

    private fun getAutoTickets(lottoPurchaseInfo: LottoPurchaseInfo): List<LottoTicket> {
        val autoLottoCount = lottoPurchaseInfo.autoLottoCount
        return (1..autoLottoCount).map { LottoTicket.autoGenerate() }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
