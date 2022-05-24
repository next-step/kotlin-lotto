package lotto

class LottoJudgment(
    private val lastLottoWinnerTicket: LottoTicket,
    private val bonusNumber: Int = LottoPolicy.NO_BONUS_NUMBER
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

    fun matchNumberCount(ticket: LottoTicket): Int {
        return lastLottoWinnerTicket.matchCountWith(ticket)
    }

    fun getRanking(matchNumberCount: Int, hasBonusNumber: Boolean): LottoWinnerRank {
        return LottoWinnerRank.getRank(matchNumberCount, hasBonusNumber)
    }
}
