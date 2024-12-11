package lotto.domain

import lotto.domain.LottoTicket.Companion.LOTTO_TICKET_SIZE

class WinningLotto(numbers: List<Int>) {
    private val _lottoNumbers: Set<Int> = numbers.toSortedSet()
    val lottoNumbers: Set<Int>
        get() = _lottoNumbers.toSet()

    constructor() : this(LottoTicket.generateLottoNumber().lottoNumbers.toList())

    init {
        require(numbers.size == LOTTO_TICKET_SIZE) { "당첨 번호 입력이 유효하지 않습니다" }
    }

    fun calculateMatchCount(lottoTicket: LottoTicket): Int {
        return lottoNumbers.intersect(lottoTicket.lottoNumbers).size
    }
}
