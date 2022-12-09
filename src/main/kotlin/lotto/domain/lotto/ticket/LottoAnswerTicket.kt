package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.result.LottoTicketResult
import lotto.domain.lotto.result.LottoResultMap

class LottoAnswerTicket(
    val answerLottoTicket: LottoTicket,
    val bonusLottoNumber: LottoNumber? = null
) {
    init {
        require(!answerLottoTicket.contains(bonusLottoNumber)) {
            "bonusLottoNumber($bonusLottoNumber) should be different from answerLottoTicket ($answerLottoTicket)"
        }
    }

    fun result(lottoTicket: LottoTicket): LottoTicketResult = LottoTicketResult(
        matchCount(lottoTicket),
        containsBonusLottoNumber(lottoTicket)
    )

    fun result(lottoTicketList: List<LottoTicket>): LottoResultMap = LottoResultMap(
        lottoTicketList.map { result(it) }
    )

    fun matchCount(lottoTicket: LottoTicket): Int =
        answerLottoTicket.matchCount(lottoTicket)

    private fun containsBonusLottoNumber(lottoTicket: LottoTicket): Boolean =
        lottoTicket.contains(bonusLottoNumber)
}
