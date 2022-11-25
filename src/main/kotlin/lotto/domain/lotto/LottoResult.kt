package lotto.domain.lotto

import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.ticket.LottoTicket

class LottoResult(lottoResultNumberList: List<Int>) {
    val lottoNumberList: List<LottoNumber>

    init {
        require(lottoResultNumberList.toSet().size == LottoTicket.TOTAL_COUNT_LOTTO_NUMBER) {
            "LottoResultNumberList must contain exactly ${LottoTicket.TOTAL_COUNT_LOTTO_NUMBER}"
        }

        lottoNumberList = lottoResultNumberList.map { LottoNumber(it) }.sorted()
    }

    override fun toString(): String {
        return lottoNumberList.joinToString(", ", "[", "]")
    }
}
