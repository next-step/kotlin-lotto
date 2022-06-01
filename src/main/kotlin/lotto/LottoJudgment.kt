package lotto

class LottoJudgment(
    private val lastLottoWinnerTicket: LottoTicket,
    private val bonusNumber: LottoNumber
) {
    init {
        require(!lastLottoWinnerTicket.hasNumber(bonusNumber)) {
            "보너스 숫자는 지난 당첨번호에 포함될 수 없습니다."
        }
    }

    fun getRanking(ticket: LottoTicket): LottoWinnerRank {
        val matchNumberCount = matchNumberCount(ticket)
        return getRanking(matchNumberCount, ticket.hasNumber(bonusNumber))
    }

    private fun matchNumberCount(ticket: LottoTicket): Int {
        return lastLottoWinnerTicket.matchCountWith(ticket)
    }

    private fun getRanking(matchNumberCount: Int, hasBonusNumber: Boolean): LottoWinnerRank {
        return LottoWinnerRank.getRank(matchNumberCount, hasBonusNumber)
    }
}
