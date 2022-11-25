package lotto.domain.lotto.ticket

import java.util.stream.Stream

class LottoTicketContainer {

    private val _list: MutableList<LottoTicket> = mutableListOf()

    val list: List<LottoTicket>
        get() = _list

    fun addLottoTicket() {
        _list.add(generateLottoTicket())
    }

    private fun generateLottoTicket(): LottoTicket =
        Stream.generate { LottoTicket.randomGenerate() }
            .filter { !_list.contains(it) }
            .findFirst()
            .get()
}
