package lotto.domain.lotto.ticket

import java.util.stream.Stream

class LottoTicketContainer(
    private val _list: MutableList<LottoTicket> = mutableListOf()
): List<LottoTicket> by _list {

//    val list: List<LottoTicket>
//        get() = _list
//
//    val size: Int
//        get() = _list.size

    fun addLottoTicket() {
        _list.add(generateLottoTicket())
    }

    private fun generateLottoTicket(): LottoTicket =
        Stream.generate { LottoTicket.randomGenerate() }
            .filter { !_list.contains(it) }
            .findFirst()
            .get()
}
