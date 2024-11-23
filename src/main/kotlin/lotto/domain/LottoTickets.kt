package lotto.domain

class LottoTickets private constructor(
    money: Int,
    manualLottoCount: Int,
    manualNumbers: List<Set<Int>>,
) {
    val manualTickets: List<LottoTicket> = getManualTickets(manualNumbers)

    val autoTickets: List<LottoTicket> = getAutoTickets(money, manualLottoCount)

    val tickets = manualTickets + autoTickets

    fun getTicketTotalPrice(): Int {
        return tickets.size * LOTTO_PRICE
    }

    private fun getManualTickets(manualNumbers: List<Set<Int>>): List<LottoTicket> {
        return manualNumbers.map { LottoTicket.of(it) }
    }

    private fun getAutoTickets(
        money: Int,
        manualLottoCount: Int,
    ): List<LottoTicket> {
        val autoLottoCount = (money - manualLottoCount * LOTTO_PRICE) / LOTTO_PRICE
        return (1..autoLottoCount).map { LottoTicket.autoGenerate() }
    }

    companion object {
        const val LOTTO_PRICE = 1000

        fun of(
            money: Int,
            manualLottoCount: Int,
            manualNumbers: List<Set<Int>>,
        ): LottoTickets {
            return LottoTickets(money, manualLottoCount, manualNumbers)
        }
    }
}
