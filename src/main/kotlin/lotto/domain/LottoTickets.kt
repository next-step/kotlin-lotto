package lotto.domain

class LottoTickets(
    money: Int,
    manualLottoCount: Int,
    manualNumbers: List<Set<Int>>
) {
    val manualTickets: List<LottoTicket> = getManualTickets(manualNumbers)

    val autoTickets: List<LottoTicket> = getAutoTickets(money, manualLottoCount)

    val tickets = manualTickets + autoTickets

    private fun getManualTickets(manualNumbers: List<Set<Int>>): List<LottoTicket> {
        return manualNumbers.map { LottoTicket(it) }
    }

    private fun getAutoTickets(money: Int, manualLottoCount: Int): List<LottoTicket> {
        val autoLottoCount = (money - manualLottoCount * 1_000) / 1_000
        return (1..autoLottoCount).map { LottoTicket.autoGenerate() }
    }

}
