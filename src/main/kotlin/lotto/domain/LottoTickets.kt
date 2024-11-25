package lotto.domain

import lotto.domain.rank.Rank

class LottoTickets(
    lottoPurchaseInfo: LottoPurchaseInfo,
    manualNumbers: List<Set<Int>>,
) {
    val manualTickets: List<LottoTicket> = getManualTickets(manualNumbers)

    val autoTickets: List<LottoTicket> = getAutoTickets(lottoPurchaseInfo)

    val tickets = manualTickets + autoTickets

    val totalTicketPrice = tickets.size * LOTTO_PRICE

    fun match(winningLottoNumbers: Set<LottoNumber>, bonusNumber: LottoNumber): Map<Rank, Int> {
        val matchResult = tickets.map { it.match(winningLottoNumbers, bonusNumber) }
        return Rank.entries.associateWith { rank -> matchResult.count { it == rank } }
    }

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
