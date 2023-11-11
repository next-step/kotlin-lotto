package lotto.domain

data class WinningLotto(
    val winningTicket: LottoTicket,
    val bonusNumber: Int,
) {
    init {
        LottoTicketGenerator.checkNumber(bonusNumber)
        require(!winningTicket.contains(bonusNumber)) {
            "보너스 볼과 당첨번호 숫자가 중복됩니다"
        }
    }

    fun rank(ticket: LottoTicket): LottoRank {
        val matchedCount = winningTicket countMatched ticket
        val matchesBonus = ticket contains bonusNumber
        return LottoRank.valueOf(matchedCount, matchesBonus)
    }
}
