package lotto.domain.lotto.ticket

import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.result.LottoResultMap
import lotto.domain.lotto.result.LottoTicketResult

class LottoAnswerTicket(
    private val answerLottoTicket: LottoTicket,
    private val bonusLottoNumber: LottoNumber =
        LottoNumber.values().first { !answerLottoTicket.contains(it) }
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
