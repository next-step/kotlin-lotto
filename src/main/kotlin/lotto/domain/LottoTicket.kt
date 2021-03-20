package lotto.domain

class LottoTicket(
    val manuals: List<Lotto>,
    val automatics: List<Lotto>
) {

    fun getTickets(): List<Lotto> {
        val tickets: MutableList<Lotto> = manuals.toMutableList()
        tickets.addAll(automatics)

        return tickets
    }
}
