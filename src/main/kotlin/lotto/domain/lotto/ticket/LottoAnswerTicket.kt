package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber

class LottoAnswerTicket(
    lottoAnswerNumberList: List<LottoNumber>
) : LottoTicket(lottoAnswerNumberList) {

    constructor(vararg lottoNumbers: Int) : this(lottoNumbers.map { LottoNumber(it) }.sorted())

    fun calculateMatchCount(lottoTicket: LottoTicket): Int = this.intersect(lottoTicket).size
}
