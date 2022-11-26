package lotto.domain.lotto

import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.result.LottoResultCountMap
import lotto.domain.lotto.ticket.LottoTicket

class LottoAnswer(lottoAnswerNumberList: List<Int>) {
    val lottoNumberList: List<LottoNumber>

    init {
        require(lottoAnswerNumberList.toSet().size == LottoTicket.TOTAL_COUNT_LOTTO_NUMBER) {
            "LottoResultNumberList must contain exactly ${LottoTicket.TOTAL_COUNT_LOTTO_NUMBER}"
        }

        lottoNumberList = lottoAnswerNumberList.map { LottoNumber(it) }.sorted()
    }

    fun calculate(lottoTicket: LottoTicket): Int =
        lottoTicket.lottoNumberList.count { it in lottoNumberList }

    fun calculate(lotto: Lotto): LottoResultCountMap =
        LottoResultCountMap(lotto.lottoTicketList.groupingBy { calculate(it) }.eachCount())

    override fun toString(): String {
        return lottoNumberList.joinToString(", ", "[", "]")
    }
}
