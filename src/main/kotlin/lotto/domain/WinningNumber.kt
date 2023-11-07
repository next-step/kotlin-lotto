package lotto.domain

import java.lang.IllegalArgumentException

data class WinningNumber(private var _lottoNumberList: List<LottoNumber>) {
    val lottoNumberList get() = _lottoNumberList

    init {
        require(_lottoNumberList.size == 6) {
            throw IllegalArgumentException("Invalid Winning number size: winning number should have exact 6 numbers: $lottoNumberList")
        }
        require(_lottoNumberList.toSet().size == 6) {
            throw IllegalArgumentException("Duplicated winning number: winning number should not have duplicated number: $lottoNumberList")
        }
        _lottoNumberList = _lottoNumberList.sortedBy { it.value }
    }

    fun getHitCount(lottoTicket: LottoTicket): Int {
        var hitCount = 0

        lottoTicket.lottoNumberList.forEach { number ->
            if (_lottoNumberList.map { it.value }.contains(number.value)) {
                hitCount += 1
            }
        }
        return hitCount
    }
}
