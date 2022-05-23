package lotto.agency

class LottoTicket(private val _numbers: List<Int>) {

    val numbers: List<Int>
        get() {
            return _numbers
        }

    fun countMatchWonLottoTicket(wonLottoTicket: LottoTicket): Int {
        return _numbers
            .sorted()
            .count { wonLottoTicket._numbers.contains(it) }
    }
}
